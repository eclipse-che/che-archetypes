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

CLI_IMAGE=eclipse/che-cli:nightly
DATA_MOUNT=$HOME/.che/sample/data
ASSEMBLY_MOUNT=$PWD/assembly/assembly-main/target/eclipse-che-0.1-SNAPSHOT/eclipse-che-0.1-SNAPSHOT


#TODO detect version of assembly. detect version of che
docker_exec run -it --rm  ${DOCKER_RUN_OPTIONS}  \
         -v /var/run/docker.sock:/var/run/docker.sock \
         -v "$DATA_MOUNT:/data" \
         -v "$ASSEMBLY_MOUNT:/assembly" \
         $CLI_IMAGE stop
