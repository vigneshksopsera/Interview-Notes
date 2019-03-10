

List

list.addAll(Collection<Datatype>)

Map


Treemap - freqMap.pollLastEntry()


Comparator using Lambda expressions

PriorityQueue<Map.Entry<Integer, Integer>> maxHeap = 
                         new PriorityQueue<>((a,b)->(b.getValue()-a.getValue()));
                         
intervals.sort((i1, i2) -> Integer.compare(i1.start, i2.start));     

Collections.sort(collection<Element> ,new Comparator<Interval>(){
    public int compare (Element i1, Element i2){
        return i1.start - i2.start;
    }
});