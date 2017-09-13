import java.util.*;

public class Main {

    public static void main(String[] args) {
        UnionFindSetsAmazon unionFindSetsAmazon = new UnionFindSetsAmazon();
        List<Relation> relations = new ArrayList<>();
        relations.add(new Relation("book1","book2"));
        relations.add(new Relation("book5","book7"));
        relations.add(new Relation("book1","book3"));
        relations.add(new Relation("book4","book5"));
        relations.add(new Relation("book5","book7"));
        relations.add(new Relation("book5","book1"));
        Map<Integer,List<String>> result = unionFindSetsAmazon.unionFindSets(relations);
        for(List<String> strings:result.values()){
            if(!strings.isEmpty())
                System.out.println(strings);
        }
    }
}
