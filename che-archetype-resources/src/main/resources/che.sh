#!/bin/bash
#
# Copyright (c) 2012-2017 Codenvy, S.A.
# All rights reserved. This program and the accompanying materials
# are made available under the terms of the Eclipse Public License v1.0
# which accompanies this distribution, and is available at
# http://www.eclipse.org/legal/epl-v10.html
#
# Contributors:
#   Codenvy, S.A. - initial API and implementation
#

# See: https://sipb.mit.edu/doc/safe-shell/
set -e
set -u

build(){
  #TODO detect m2 repo from settings.xml
  docker_exec run -it --rm --name build-che \
           -v "$HOME/.m2:/home/user/.m2"    \
           -v "$PWD":/home/user/che-build   \
           -w /home/user/che-build          \
           codenvy/che-dev                  \
           mvn clean install

}

run(){
#TODO detect version of assembly. detect version of che
docker_exec run -it --rm  ${DOCKER_RUN_OPTIONS}  \
         -v /var/run/docker.sock:/var/run/docker.sock \
         -v /tmp/.wizard-sample/data:/data \
         -v "$PWD"/assembly/assembly-main/target/eclipse-che-0.1-SNAPSHOT/eclipse-che-0.1-SNAPSHOT:/assembly \
         eclipse/che-cli:nightly start
 }

init() {
  init_constants

  # If there are no parameters, immediately display usage
  if [[ $# == 0 ]]; then
    usage;
  fi

  if [[ "$@" == *"--build"* ]]; then
    CHE_BUILD=true;
  fi

  if [[ "$@" == *"--run"* ]]; then
    CHE_RUN=true;
  fi

  # Make sure Docker is working and we have /var/run/docker.sock mounted or valid DOCKER_HOST
  check_docker "$@"


}

usage() {
 # debug $FUNCNAME
  init_usage
  printf "%s" "${USAGE}"
  return 1;
}


init_usage() {
  USAGE="
USAGE:
TODO  
"
}
init_constants() {
  BLUE='\033[1;34m'
  GREEN='\033[0;32m'
  RED='\033[0;31m'
  YELLOW='\033[38;5;220m'
  BOLD='\033[1m'
  UNDERLINE='\033[4m'
  NC='\033[0m'
  
  CHE_BUILD=false;
  CHE_RUN=false;

  DOCKER_RUN_OPTIONS=""
  BATS_OPTIONS=""
  # run bats with terminal mode (pretty print) if supported by current shell
  if [ -t 1 ]; then
    DOCKER_RUN_OPTIONS="-t"
    BATS_OPTIONS="--pretty"
  else
    BATS_OPTIONS="--tap"
  fi
  
  # Replace all of these with digests
  UTILITY_IMAGE_ALPINE="alpine:3.4"
  UTILITY_IMAGE_CHEIP="eclipse/che-ip:nightly"
  UTILITY_IMAGE_CHEACTION="eclipse/che-action:nightly"
  UTILITY_IMAGE_CHEDIR="eclipse/che-dir:nightly"
  UTILITY_IMAGE_CHETEST="eclipse/che-test:nightly"
  UTILITY_IMAGE_CHEMOUNT="eclipse/che-mount:nightly"
}

check_docker() {
  if ! docker ps > /dev/null 2>&1; then
    output=$(docker ps)
    printf "${RED}Docker not installed properly: ${output}${NC}\n"
    exit 1
  fi
}



docker_exec() {
  if has_docker_for_windows_client; then
    MSYS_NO_PATHCONV=1 docker.exe "$@"
  else
    "$(which docker)" "$@"
  fi
}

has_docker_for_windows_client(){
  GLOBAL_HOST_ARCH=$(docker version --format {{.Client}} | cut -d" " -f5)

  if [ "${GLOBAL_HOST_ARCH}" = "windows" ]; then
    return 0
  else
    return 1
  fi
}

get_full_path() {
  echo "$(cd "$(dirname "${1}")"; pwd)/$(basename "$1")"
}

convert_windows_to_posix() {
  echo "/"$(echo "$1" | sed 's/\\/\//g' | sed 's/://')
}

get_clean_path() {
  INPUT_PATH=$1
  # \some\path => /some/path
  OUTPUT_PATH=$(echo ${INPUT_PATH} | tr '\\' '/')
  # /somepath/ => /somepath
  OUTPUT_PATH=${OUTPUT_PATH%/}
  # /some//path => /some/path
  OUTPUT_PATH=$(echo ${OUTPUT_PATH} | tr -s '/')
  # "/some/path" => /some/path
  OUTPUT_PATH=${OUTPUT_PATH//\"}
  echo ${OUTPUT_PATH}
}

get_mount_path() {
  FULL_PATH=$(get_full_path "${1}")
  POSIX_PATH=$(convert_windows_to_posix "${FULL_PATH}")
  CLEAN_PATH=$(get_clean_path "${POSIX_PATH}")
  echo $CLEAN_PATH
}


init "$@"

if [ "${CHE_BUILD}" = "true" ]; then
    build  
fi

if [ "${CHE_RUN}" = "true" ]; then
    run
fi
