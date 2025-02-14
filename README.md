Spring boot Restful exemple with docker

Here some basics command to create images and run it

I am using name guest/springapi to create image and run with name guestapi and you can change those names.

Before to run these commands open terminal into root folder folder with file Dockerfile.

Create images with docker and SDK
docker build --tag guest/springapi .

Run image
docker run --name guestapi -p 8080:8080 -d guest/springapi

See running docker
docker ps

Stop container docker
docker stop guestapi

Start container
docker start guestapi

Remove container (stop container before to run this command)
docker rm guestapi

See all images
docker images 

Remove image
docker rmi guest/springapi
