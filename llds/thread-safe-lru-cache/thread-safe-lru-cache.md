
Design Thread Safe LRU Cache with TTL

# Requirements

- get, put, remove should perform in O(1)
- Simple APIs
- key should be evicted from the cache after TTL is expired
- should be thread safe
- when cache is full, key should be evicted based on LRU policy.


# Entities

- CacheWithTTL
- DLL
- Concurrent Map


# Design Patterns

- Strategy Pattern to decide Cache eviction policy.
- Command Pattern to interact with Cache.

# Example

- Cache Size = 3
- Access Pattern = 1 2 3 4 1 1 2 4 3

Cache 0 : 1
Cache 1 : 2
Cache 2 : 3


DLL
head -> 3 -> 2 -> 1 -> tail

Map
{
    1: Node(1),
    2: Node(2),
    3: Node(3)
}


put(k):
    - if cache is full
        - lru key = tail -> prev
        - remove lru key
    - add k to head of DLL
    - add k to map
    - update size


get(k):
    - get access to Node using map
    - move node to front of DLL
    - return value


remove(k):
    - get access to node using map
    - remove from DLL
    - remove from map
    - update size