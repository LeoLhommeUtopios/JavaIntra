docker exec -it kafka kafka-console-consumer --topic demo-output-branch-topic-1 --bootstrap-server localhost:9092 --from-beginning

docker exec -it kafka kafka-console-consumer --topic input-topic --bootstrap-server localhost:9092 --from-beginning

docker exec -it kafka kafka-topics --create --topic demo-stream-merge1-topic --bootstrap-server localhost:9092 --partitions 1 --replication-factor 1