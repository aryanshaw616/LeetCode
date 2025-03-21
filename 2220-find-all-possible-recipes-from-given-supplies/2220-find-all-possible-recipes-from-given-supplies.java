class Solution
{
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies)
    {
        List<String> list = new LinkedList<>();
        Set<String> supp = Arrays.stream(supplies).collect(Collectors.toSet());
        Map<String,Set<String>> map = new HashMap<>();
        for(int i=0;i<recipes.length;i++)
        {
            map.put(recipes[i],new HashSet<>(ingredients.get(i)));
        }
        for(Set<String> set : map.values())
        {
            for(String s : supp)
            {
                set.remove(s);
            }
        }
        supp.clear();
        while(map.values().stream().filter(set->set.isEmpty()).count()>0L)
        {
            Iterator<Map.Entry<String,Set<String>>> it = map.entrySet().iterator();
            while(it.hasNext())
            {
                Map.Entry<String,Set<String>> ent = it.next();
                if(ent.getValue().isEmpty())
                {
                    supp.add(ent.getKey());
                    list.add(ent.getKey());
                    it.remove();
                }
            }
            for(Set<String> set : map.values())
            {
                for(String s : supp)
                {
                    set.remove(s);
                }
            }
            supp.clear();
        }
        return list;
    }
}