package structures;

import java.util.Comparator;

public class StudentArrayHeap<P, V> extends AbstractArrayHeap<P, V> {

	protected StudentArrayHeap(Comparator<P> comparator) {
		super(comparator);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected int getLeftChildOf(int index) {
		if(index < 0) throw new IndexOutOfBoundsException();
		//as explained in the power point
		return (2*index+1);
	}

	@Override
	protected int getRightChildOf(int index) {
		if(index < 0) throw new IndexOutOfBoundsException();
		//as explained in the power point
		return (2*index+2);
	}

	@Override
	protected int getParentOf(int index) {
		if(index <= 0) throw new IndexOutOfBoundsException();
		//as explained in the power point
		return ((index-1)/2);
	}

	@Override
	protected void bubbleUp(int index) {
		int hole = index;
		//whilethe parent is less than the child and the hole is not at the root
		while((hole > 0) && (super.comparator.compare(heap.get(getParentOf(hole)).getPriority(), heap.get(hole).getPriority())) < 0){
			int parent = getParentOf(hole);
			//swap the parent and the hole
			swap(hole,parent);
			//change the hole to be the parent
			hole = parent;
		}	
	}

	@Override
	protected void bubbleDown(int index) {
		int biggestChild = getLeftChildOf(index);
			
			if(getLeftChildOf(index) < heap.size() == false){
				return;
			}
			//figure out ehich child is bigger
			if(getRightChildOf(index) < heap.size() && super.comparator.compare(heap.get(getLeftChildOf(index)).getPriority(), heap.get(getRightChildOf(index)).getPriority()) < 0){
				biggestChild = getRightChildOf(index);
				//if the node at index has less priority than it's left children swap
			}
			if(super.comparator.compare(heap.get(biggestChild).getPriority(), heap.get(index).getPriority()) > 0){
				swap(biggestChild,index);
				bubbleDown(biggestChild);
			}else{
				bubbleDown(heap.size());
			}
	}
	
}
