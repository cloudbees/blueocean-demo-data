#!/usr/bin/env bash
set -eu -o pipefail

# cleanup previous demo data volume
docker rm -v blueocean-demo-data || true
docker create --name blueocean-demo-data blueocean/blueocean-demo-data

docker run --rm -p 8080:8080 --volumes-from blueocean-demo-data blueocean/blueocean
