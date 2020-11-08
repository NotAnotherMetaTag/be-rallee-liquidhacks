aws dynamodb create-table \
 --table-name User \
 --attribute-definitions \
     AttributeName=Id,AttributeType=S \
 --key-schema \
     AttributeName=Id,KeyType=HASH \
 --provisioned-throughput \
     ReadCapacityUnits=5,WriteCapacityUnits=5 \
 --region us-west-1 \
 --endpoint-url http://localhost:8000

aws dynamodb create-table \
 --table-name Player \
 --attribute-definitions \
    AttributeName=email,AttributeType=S \
 --key-schema \
    AttributeName=email,KeyType=HASH \
 --provisioned-throughput \
    ReadCapacityUnits=5,WriteCapacityUnits=5 \
 --region us-west-1 \
 --endpoint-url http://localhost:8000