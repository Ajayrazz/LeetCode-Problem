class DisjointSet {
    List<Integer> parent = new ArrayList<>();
    List<Integer> size = new ArrayList<>();

    public DisjointSet(int n){
        for(int i = 0; i < n; i++){
            size.add(1);
            parent.add(i);
        }
    }

    //findUPar function
    public int findUPar(int node){
        if(node == parent.get(node)) return parent.get(node);
        int ulp = findUPar(parent.get(node));
        parent.set(node, ulp);
        return parent.get(node);
    }

    //unionBySize function
    public void unionBySize(int u, int v){
        int ulpU = findUPar(u);
        int ulpV = findUPar(v);
        if(ulpU == ulpV) return;
        if(size.get(ulpU) < size.get(ulpV)){
            parent.set(ulpU, ulpV);
            size.set(ulpV, size.get(ulpU) + size.get(ulpV));
        }
        else {
            parent.set(ulpV, ulpU);
            size.set(ulpU, size.get(ulpU) + size.get(ulpV));
        }
    }
}

class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size();
        DisjointSet ds = new DisjointSet(n);
        List<List<String>> result = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        for(int i = 0; i < n; i++){
            for(int j = 1; j < accounts.get(i).size(); j++){
                String mail = accounts.get(i).get(j);
                if(!map.containsKey(mail)){
                    map.put(mail, i);
                }
                else {
                    ds.unionBySize(i, map.get(mail));
                }
            }
        }

        List<String>[] mergedMail = new ArrayList[n];
        for(int i = 0; i < n; i++){
            mergedMail[i] = new ArrayList<>();
        }

        for(Map.Entry<String, Integer> entry : map.entrySet()){
            String mail = entry.getKey();
            int node = ds.findUPar(entry.getValue());
            mergedMail[node].add(mail);
        }
        
        for(int i = 0; i < n; i++){
            if(mergedMail[i].size() == 0) continue;
            Collections.sort(mergedMail[i]);
            List<String> temp = new ArrayList<>();
            temp.add(accounts.get(i).get(0));
            for(String mail : mergedMail[i]){
                temp.add(mail);
            }
            //add temp to result
            result.add(new ArrayList<>(temp));
        }

        return result;
    }
}