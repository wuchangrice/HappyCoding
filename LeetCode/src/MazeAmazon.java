import java.util.*;

/**
 * Created by oukinsei on 9/12/17.
 */
public class MazeAmazon {
    private class Position{
        int x;
        int y;

        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Position position = (Position) o;

            if (x != position.x) return false;
            return y == position.y;
        }

        @Override
        public int hashCode() {
            int result = x;
            result = 31 * result + y;
            return result;
        }
    }
    public int[] flatFields (int numRows, int numColumns, List<List<Integer>> fields){
        //get all trees
        TreeMap<Integer,Position> treeMap = new TreeMap<>();
        for(int i=0; i<numRows;i++){
            for(int j=0; j<numColumns;j++){
                if(fields.get(i).get(j) > 1)
                    treeMap.put(fields.get(i).get(j), new Position(i,j));
            }
        }

        //
        int i = 0;
        int[] results = new int[4];
        Position[] positions = {new Position(0,0),new Position(numRows-1,numColumns-1),new Position(0,numColumns-1),new Position(numRows-1,0)};
        while(i < 4) {
            int result = 0;
            Position startPosition = positions[i];
            Iterator it = treeMap.keySet().iterator();
            while (it.hasNext()) {
                int treeHeight = (int) it.next();
                Position endPosition = treeMap.get(treeHeight);
                int currentLength = findLengthBetweenPosition(startPosition, endPosition, numRows, numColumns, fields);
                if (currentLength == 0) {
                    return new int[]{-1,-1,-1,-1};
                }
                //position init
                result += treeHeight;
                result += currentLength;
                startPosition = endPosition;
//            fields.get(startPosition.x).set(startPosition.y, 1);
            }
            results[i] = result;
            i++;
        }
        return results;
    }

    //if not connected,return 0
    private int findLengthBetweenPosition(Position a, Position b, int numRows, int numColumns, List<List<Integer>> fields){
        //init
        Set<Position> aStartSet = new HashSet<Position>(){{add(a);}};
        Set<Position> bStartSet = new HashSet<Position>(){{add(b);}};
        List<Set<Position>> aList = new ArrayList<>();
        aList.add(aStartSet);
        Set<Position> aTotalSet = new HashSet<>();
        aTotalSet.addAll(aStartSet);
        List<Set<Position>> bList = new ArrayList<>();
        bList.add(bStartSet);
        Set<Position> bTotalSet = new HashSet<>();
        bTotalSet.addAll(bStartSet);

        for(int i=0; ;i++){
            Set<Position> aCurrentSet = new HashSet<>();
            Set<Position> bCurrentSet = new HashSet<>();

            for(Position aCurrent:aList.get(i)) {
                aCurrentSet.addAll(findPositionNearby(aCurrent, numRows, numColumns, fields));
            }
            for(Position bCurrent:bList.get(i)) {
                bCurrentSet.addAll(findPositionNearby(bCurrent, numRows, numColumns, fields));
            }
            aCurrentSet.removeAll(aTotalSet);
            bCurrentSet.removeAll(bTotalSet);
            aList.add(aCurrentSet);
            bList.add(bCurrentSet);
            aTotalSet.addAll(aCurrentSet);
            bTotalSet.addAll(bCurrentSet);
            if(aCurrentSet.isEmpty() || bCurrentSet.isEmpty())
                return 0;
            if(setIntersect(aCurrentSet,bCurrentSet))
                return 2*i + 2;
            if(setIntersect(aTotalSet,bTotalSet)){
                return 2*i+1;
            }
        }
    }

    //findPositionNearby
    private Set<Position> findPositionNearby(Position a, int numRows, int numColumns, List<List<Integer>> fields ){
        Set<Position> result = new HashSet<>();
        if(a.x > 0 && fields.get(a.x-1).get(a.y) == 1){
            result.add(new Position(a.x-1, a.y));
        }
        if(a.y > 0 && fields.get(a.x).get(a.y-1) == 1){
            result.add(new Position(a.x, a.y-1));
        }
        if(a.x < numRows -1 && fields.get(a.x+1).get(a.y) == 1){
            result.add(new Position(a.x+1, a.y));
        }
        if(a.y < numColumns-1 && fields.get(a.x).get(a.y+1) == 1){
            result.add(new Position(a.x, a.y+1));
        }
        return result;
    }

    //if set has common element
    private boolean setIntersect(Set<Position> a, Set<Position> b){
        if(a.isEmpty() || b.isEmpty())
            return false;
        //todo small set outside
        for(Position p:a){
            if(b.contains(p))
                return true;
        }
        return false;
    }

}
