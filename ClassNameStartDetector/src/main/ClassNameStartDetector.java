package main;
import org.apache.bcel.classfile.JavaClass;
import org.apache.bcel.classfile.Method;

import edu.umd.cs.findbugs.BugInstance;
import edu.umd.cs.findbugs.BugReporter;
import edu.umd.cs.findbugs.Detector;
import edu.umd.cs.findbugs.Priorities;
import edu.umd.cs.findbugs.SourceLineAnnotation;
import edu.umd.cs.findbugs.ba.ClassContext;
import edu.umd.cs.findbugs.classfile.DescriptorFactory;

public class ClassNameStartDetector implements Detector{

	private BugReporter bugreporter;
	
	public ClassNameStartDetector(BugReporter be)
	{
		this.bugreporter=be;
	}
	
	@Override
	public void report() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitClassContext(ClassContext classContext) {
		// TODO Auto-generated method stub
	 JavaClass cls = classContext.getJavaClass();
	 String clsname = cls.getClassName();
	 
	 if(clsname.charAt(0) >= 'a' && clsname.charAt(0) <= 'z')
	 {
		 BugInstance bug = new BugInstance("ClassName_Bug",Priorities.NORMAL_PRIORITY).addClass(classContext.getClassDescriptor());
		 bugreporter.reportBug(bug);
	 }
 
	}
	
}
