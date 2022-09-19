class Solution {
    public List<List<String>> findDuplicate(String[] paths) {
        HashMap<String, List<String> > map  = new HashMap<>();
 
        for(int i = 0; i < paths.length; i++){
            String str = paths[i];
            String arr[] = str.split(" ");
            String rootDirectory = arr[0];
            for(int j = 1; j < arr.length; j++){
                String pathName = arr[j].substring(0, arr[j].indexOf('('));
                String content  = arr[j].substring(arr[j].indexOf('(')+1, arr[j].length() - 1);
                List<String> list = map.getOrDefault(content, new ArrayList<String>());
                String fullPathName = rootDirectory+ "/" + pathName;
               // System.out.println(fullPathName);
                list.add(fullPathName);
                map.put(content, list);
            }
        } 
        List<List<String>> list = new ArrayList<>();
        for(Map.Entry<String, List<String>> iter : map.entrySet()){
           List<String> ll = iter.getValue();
           if(ll.size()>=2) list.add(ll);
         //   System.out.println(ll);
         }
        return list;
    }
   
    //   root/a 1.txt(abcd) 2.txt(efgh)
}

