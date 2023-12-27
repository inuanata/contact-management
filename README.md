## How to run
```
docker run -it --rm --name my-maven-project -p 8080:8080 --network laravel-docker-network -v "$(pwd)":/usr/src/mymaven -w /usr/src/mymaven maven sh
```