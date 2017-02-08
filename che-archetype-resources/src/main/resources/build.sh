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

. ./build.include
init "$@"

if has_docker_for_windows_client; then
# Convert files to Unix format with dos2unix
/usr/bin/find . -type f -exec dos2unix {} \;
fi

#TODO detect m2 repo from settings.xml
docker_exec run -it --rm --name build-che \
       -v "$HOME/.m2:/home/user/.m2"    \
       -v "$PWD":/home/user/che-build   \
       -w /home/user/che-build          \
       codenvy/che-dev                  \
       mvn clean install
