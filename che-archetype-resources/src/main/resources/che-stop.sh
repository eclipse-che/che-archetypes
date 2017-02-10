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

#TODO detect version of assembly. detect version of che
docker_exec run -it --rm  ${DOCKER_RUN_OPTIONS}  \
         -v /var/run/docker.sock:/var/run/docker.sock \
         -v "$HOME/.che/sample/data:/data" \
         -v "$PWD"/assembly/assembly-main/target/eclipse-che-0.1-SNAPSHOT/eclipse-che-0.1-SNAPSHOT:/assembly \
         eclipse/che-cli:nightly stop
