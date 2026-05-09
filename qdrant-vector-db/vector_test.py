from qdrant_client import QdrantClient
from qdrant_client.models import Distance, VectorParams, PointStruct
from sentence_transformers import SentenceTransformer

client = QdrantClient("localhost", port=6333)
collection_name = "test_collection"

model = SentenceTransformer("all-MiniLM-L6-V2")


if not client.collection_exists(collection_name):
    client.create_collection(
        collection_name=collection_name,
        vectors_config=VectorParams(size = 384, distance=Distance.COSINE)
    )
    print(f"Collection '{collection_name} created.")



documents = [
    {"id": 1, "text": "The tiger is a large cat species."},
    {"id": 2, "text": "Toyota and Honda make reliable cars."},
    {"id": 3, "text": "A lion is often called the king of the jungle."},
    {"id": 4, "text": "Bananas are rich in potassium."}
]


points = []
for doc in documents:
    vector = model.encode(doc["text"]).tolist()
    points.append(PointStruct(id=doc["id"], vector=vector, payload={"text": doc["text"]}))


client.upsert(collection_name=collection_name, points=points)
print(f"Indexed {len(documents)} documents.")


query_text = "wild big cats"
query_vector = model.encode(query_text).tolist()

search_result = client.query_points(
    collection_name=collection_name,
    query=query_vector,
    limit=2
).points


for hit in search_result:
    print(f"Score: {hit.score:.4f} | Text: {hit.payload['text']}")

