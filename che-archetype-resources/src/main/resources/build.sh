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

MVN_REPO=$(mvn help:evaluate -Dexpression=settings.localRepository | grep -E '^([a-zA-Z]:|/)')
MVN_REPO=${MVN_REPO:=${HOME}/.m2/repository}

docker_exec run -it --rm --name build-che       \
       -v "$MVN_REPO:/home/user/.m2/repository" \
       -v "$PWD":/home/user/che-build           \
       -w /home/user/che-build                  \
       codenvy/che-dev                          \
       mvn clean install
