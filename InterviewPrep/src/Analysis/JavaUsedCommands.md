Streams 
--------------------------------------------------------------------------

- https://stackify.com/streams-guide-java-8/

path.stream().map(e -> e.toString()).collect(Collectors.joining())
- [ ] Map - for each element ‘e’ do some function
- [ ] Collect - Collectors.joining - collect the output of map in a list.


Collections
--------------------------------------------------------------------------


Import java.util.collections

Collections.reverse(<List>);


Arrays
-----------------------------------------------------

Arrays.copyOf



List
--------------------------------------------------------------------------

list.addAll(Collection<Datatype>)
- [ ] Return empty list. - List.of()
- [ ] Convert array to list - Arrays.asList(<the array to convert>);  P.S need to import java.util.Arrays
    - [ ] Example - Arrays.asList(s.split(" "));   // useful to split sentences into words


Queue 
--------------------------------------------------------------------------

import java.util.ArrayDeque;

queue.add()
queue.poll() // remove front of the queue
queue.peek() // look at the front item of the queue

Queue.isEmpty() // useful to check if queue is empty 


Map
--------------------------------------------------------------------------

Map<k, v> map = new HashMap<>();

map.keySet() returns the key stored in the map. The key will 


Inbuilt key - Integer.hashCode(key);
Treemap - freqMap.pollLastEntry()


Priority Queue
--------------------------------------------------------

PriorityQueue<T> maxHeap = new PriorityQueue<>(capacity, <T>(key to store));

PriorityQueue<Element> heap = new PriorityQueue<>(lists.size(), Comparator.comparingInt(e -> e.val));

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((o1, o2) -> Integer.compare(o2, o1));

PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(o -> o[0]));

  

String
--------------------------------------------------------------------------------------

String.join("->", [1,2,3]). Result = 1->2->3

S.isEmpty()

StringBuilder sb = new StringBuilder(<"some string">)

sb.append()

sb.remove(incluseive index, exclusiveIndex);



Char
----------------------------------------------------------------------------------------

char letter : new char[] {'a', 'b'}



Comparator
----------------------------------------------------------------------------------------


    Comparator using Lambda expressions
    -----------------------------------

    PriorityQueue<Map.Entry<Integer, Integer>> maxHeap = 
                            new PriorityQueue<>((a,b)->(b.getValue()-a.getValue()));
                            
    intervals.sort((i1, i2) -> Integer.compare(i1.start, i2.start));     

    Collections.sort(collection<Element> ,new Comparator<Interval>(){
        public int compare (Element i1, Element i2){
            return i1.start - i2.start;
        }
    });


    Comparator<List<Integer>> distanceComparator = new Comparator<List<Integer>>() {
        @Override
        public int compare(List<Integer> p1, List<Integer> p2) {
            return distanceToOrigin(p1) - distanceToOrigin(p2);
        }
    };

----------------------------------------------------------------------------------------

