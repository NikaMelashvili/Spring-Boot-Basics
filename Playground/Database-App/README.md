# Database related services

MinIO Docker run command

```
docker run -p 9000:9000 -p 9001:9001 --name minio -e "MINIO_ROOT_USER=root" -e "MINIO_ROOT_PASSWORD=12345678" -v C:/data/xml:/data minio/minio server /data --console-address ":9001"
```