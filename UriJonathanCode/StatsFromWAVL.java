package UriJonathanCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import javax.print.attribute.HashPrintServiceAttributeSet;



public class StatsFromWAVL {
	
	private static final int SIZE = 10000;
	private static final int MULTIPLE = 11;

	public static void main(String[] args) {
		
		double deleteOperationNum;
		double insertOperationNum;
		double maxInsertOps;
		double maxDeleteOps;
		double temp;
		WAVLTree tree;
		
		for (int multiple=1; multiple < MULTIPLE; multiple++){
			
			insertOperationNum = 0.0;
			deleteOperationNum = 0.0;
			maxInsertOps = 0.0;
			maxDeleteOps = 0.0;
			temp = 0.0;
			
			tree = new WAVLTree();
			
			ArrayList<Integer> randomKeys = getRandomKeysArray(multiple);
			
			for(int i: randomKeys ){
				temp = tree.insert(i, Integer.toString(i));
				if ( temp > maxInsertOps){
					maxInsertOps = temp;
				}
				insertOperationNum += temp;
			}
			
//			System.out.println("minNode is leaf"  + tree.minNode.isLeaf());
//			System.out.println(Arrays.toString(tree.keysToArray()));
			
			System.out.println(insertOperationNum + " is num of insert operations for tree of size: " + multiple*SIZE);
			System.out.println(insertOperationNum/(SIZE*multiple)  + " is the AVERAGE num of insert operations for tree of size: " + tree.size());
			System.out.println(maxInsertOps  + " is the MAX num of insert operations for tree of size: " + tree.size());
			System.out.println("does the tree have valid ranks?: " + WAVLTree.hasValidRanks(tree.getRoot()));
			
			
			
//			ArrayList<Integer> randomKeysDel = getRandomKeysArray(multiple);
//			
//			for(int i: randomKeysDel ){
//				temp = tree.delete(i);
//				if ( temp > maxDeleteOps){
//					maxDeleteOps = temp;
//				}
//				deleteOperationNum += temp;
//			}
//			
//			int[] array = new int[multiple*SIZE];
//			int current
//			for (int i = 0; i < multiple*SIZE; i++){
////				System.out.println(tree.minNode);
//				deleteOperationNum += tree.delete(i);
//			}
			
			
			int currentMinKey;
			while (tree.getRoot() != null){
//				if ( tree.getRoot().key >= 98){
//					System.out.println(tree.toStringPreOrder());
//				}
				currentMinKey = tree.getMinKey();
				if ( currentMinKey == 1){
//					System.out.println("toBeDeletedNode == this.minNode"+(toBeDeletedNode == this.minNode));
					System.out.println("minNode.key = "+tree.minNode.key+", minNode.isLeaf = "+tree.minNode.isLeaf()+", tree.search(1)="+tree.search(1));
					System.out.println("is the min the max" + (tree.minNode == tree.maxNode));
				}
////				System.out.println(tree.minNode.isLeaf());
//				System.out.println("minNode.key = "+tree.minNode.key+", minNode.isLeaf = "+tree.minNode.isLeaf()+", tree.search(1)="+tree.search(1));
////				System.out.println(currentMinKey);
//				System.out.println("is the min the max" + (tree.minNode == tree.maxNode));
				deleteOperationNum += tree.delete(currentMinKey);
			}
			
			System.out.println(tree.getRoot());
			System.out.println("tree size after deletion is: " + tree.size());
			System.out.println(deleteOperationNum + " is num of delete operations  for tree of size: " + multiple*SIZE);
			System.out.println(deleteOperationNum/(SIZE*multiple) + " is num of AVERAGE delete operations  for tree of size: " + multiple*SIZE);
			System.out.println(maxDeleteOps  + " is the MAX num of insert operations for tree of size: " + multiple*SIZE);
			
			System.out.println("");
			System.out.println("=================== " + SIZE*multiple + " case done ======================");
			System.out.println("");
		}
		
	}
	
	
	/*
	 * returns a random ArrayList of Integers with length of: size*10000
	 */
	public static ArrayList<Integer> getRandomKeysArray(int multiple){
		
	       ArrayList<Integer> randomKeysArray = new ArrayList<Integer>();
	        for (int i=0; i<multiple*SIZE; i++) {
	            randomKeysArray.add(new Integer(i));
	        }
	        Collections.shuffle(randomKeysArray);
//	        for (int i=0; i<3; i++) {
//	            System.out.println(randomKeysArray.get(i));
//	        }
		return randomKeysArray;
	}

}