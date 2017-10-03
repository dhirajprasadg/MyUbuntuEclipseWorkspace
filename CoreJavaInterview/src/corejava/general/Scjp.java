package corejava.general;

interface TestA{
	String toString();
}


public class Scjp {

	public static void main(String[] args) {
	 	
      new Scjp().go(1,"hia");
		
      new Scjp().go(1,"hia","dddddas");
  	
      /*System.out.println(new TestA(){
			public String toString(){
				return "test";
			}
		});*/

	}
	public void go(int i,String... y){
		System.out.println(" " + y.length+ " /" + y[y.length-1] );
	}
}
