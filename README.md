# BlueOcean demo data

This repository contains some example data to showcase BlueOcean UI. It's
designed as a Docker volume container which can be attached to a BlueOcean
docker image to have example data.

# Build

Run

    docker -t blueocean-demo-data build .

# Usage

Create a volume container and launch BlueOcean image

    docker create --name blueocean-demo-data blueocean/blueocean-demo-data
    docker run --volumes-from blueocean-demo-data blueocean/blueocean
