package awesome.persistence.agent;

import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.IllegalClassFormatException;
import java.security.ProtectionDomain;
import java.util.HashSet;

import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassWriter;

public class LazyInitAgent implements ClassFileTransformer {

	private HashSet<String> entities = new HashSet<String>();
	
	
	public void addEntity(String name) {
		System.out.println("adding " + name);
		entities.add(name);
	}
	
	
	@Override
	public byte[] transform(ClassLoader loader, String className,
			Class<?> classBeingRedefined, ProtectionDomain protectionDomain,
			byte[] b) throws IllegalClassFormatException {
		
		ClassReader cr = new ClassReader(b);
		ClassWriter cw = new ClassWriter(cr, 0);
		String tmp = className.replace("/", ".");
		if( entities.contains(tmp) ) {
			System.out.println("Transforming: " + tmp);
			cr.accept(new LazyInitAdaptor(cw, entities), 0);
			return cw.toByteArray();
		}
		
		return null;
	}
}
	
