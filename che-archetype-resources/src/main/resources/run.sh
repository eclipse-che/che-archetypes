#!/bin/bash
#
# All rights reserved. This program and the accompanying materials
# are made available under the terms of the Eclipse Public License v1.0
# which accompanies this distribution, and is available at
# http://www.eclipse.org/legal/epl-v10.html
#

# See: https://sipb.mit.edu/doc/safe-shell/
set -e
set -u

. ./build.include
init "$@"

USAGE="Specify assembly-che to run (--che or --codenvy)"

if [ $# = 0 ]; then
    echo $USAGE
    exit 1
fi

case $1 in
    --che )        CLI_IMAGE=eclipse/che-cli:nightly
                   DATA_MOUNT=$HOME/.che/sample/data
                   ASSEMBLY_MOUNT=$PWD/assembly-che/assembly-main/target/eclipse-che-0.1-SNAPSHOT/eclipse-che-0.1-SNAPSHOT
                   ;;
    --codenvy )    CLI_IMAGE=codenvy/cli:nightly
                   DATA_MOUNT=$HOME/.codenvy/sample/data
                   ASSEMBLY_MOUNT=$PWD/assembly-codenvy/assembly-main/target/codenvy-onpremises-0.1-SNAPSHOT
                   ;;
    * )            echo $USAGE
                   exit 1
esac

#TODO detect version of assembly-che. detect version of che
docker_exec run -it --rm  ${DOCKER_RUN_OPTIONS}  \
         -v /var/run/docker.sock:/var/run/docker.sock \
         -v "$DATA_MOUNT:/data" \
         -v "$ASSEMBLY_MOUNT:/assembly" \
         $CLI_IMAGE start
