import java.util.concurrent.atomic.AtomicReference;

public class AtomicReferenceTest {
	AtomicReference<String> ar= new AtomicReference<String>("ref");

	class AddThread implements Runnable{

		@Override
		public void run() {

		//if current reference is "ref" then it changes as newref
		ar.compareAndSet("ref","newref");

		// sets the new reference without any check
		ar.set("reference");

		//sets new value and return the old value
		String s= ar.getAndSet("reference1");

		System.out.println(s);

		}

	}

   public static void main(String... args){
	   new Thread(new AtomicReferenceTest().new AddThread()).start();
	   new Thread(new AtomicReferenceTest().new AddThread()).start();
   }
}