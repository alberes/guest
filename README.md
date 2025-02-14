Spring boot Restful exemple with docker

Here some basics command to create images and run it

I am using name guest/springapi to create image and run with name guestapi and you can change those names.

Before to run these commands open terminal into root folder folder with file Dockerfile.

1 - Create images with docker and SDK

docker build --tag guest/springapi .

2 - Run image

docker run --name guestapi -p 8080:8080 -d guest/springapi

3 - See running docker

docker ps

4 - Stop container docker

docker stop guestapi

5 - Start container

docker start guestapi

6 - Remove container (stop container before to run this command)

docker rm guestapi

7 - See all images

docker images 

8 - Remove image

docker rmi guest/springapi
