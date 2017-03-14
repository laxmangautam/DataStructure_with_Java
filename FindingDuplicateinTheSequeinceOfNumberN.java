
class FindingDuplicateinTheSequeinceOfNumberN {
	public static void main (String[] args) {
		int array[] ={1,2,2,3,4,5,6,7,8,9,10};
		int sum=0;
		for (int i=0;i<array.length ;i++ ) {
		    sum=sum+array[i];
		}
		
		System.out.println("sum is "+sum +" and duplice number is "+(sum-((10*(10+1))/2)));
	}
}