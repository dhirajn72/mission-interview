class MyHashSet {
    List<LinkedList>[] bucket;
    
    /** Initialize your data structure here. */
    public MyHashSet() {
        bucket=new LinkedList<>[100];
        for(int i=0;i<100;i++){
            bucket[i]=new LinkedList<>();
        } 
    }
    private int hashFunction(int key){
        return key%100;
    } 
    
    public void add(int key) {
        int indexInBucket=hashFunction(key);
        List<LinkedList> list=bucket[indexInBucket];
        list.add(key);
    }
    
    public void remove(int key) {
       int indexInBucket=hashFunction(key);
       List<LinkedList> list=bucket[indexInBucket];
       list.remove(key);
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int indexInBucket=hashFunction(key);
        List<LinkedList> list=bucket[indexInBucket];
        for(int e:list){
            if(e==key)
                return true;
        } 
        return false;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
