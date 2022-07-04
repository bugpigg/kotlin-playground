## 01. Getting Started

### 1. Collections
- Type
  - Read-only interface
    - covariant
  - mutable interface
    - collections with write operations  
    - it doesn't require to be `var`
    - reassign -> get compilation error
    - not covariant  

  ![image](https://user-images.githubusercontent.com/91416897/177184292-6fcfc3b1-5e6e-4376-bc88-c0f95d5d9ca4.png)
  from(https://kotlinlang.org/docs/collections-overview.html#collection-types)

- Detail
  - **Set**
    - `null` is unique as well
    - default is `LinkedHashSet` which preserves the order of elements insertions
    - alternative impl -> `HashSet`
      - require less memory
