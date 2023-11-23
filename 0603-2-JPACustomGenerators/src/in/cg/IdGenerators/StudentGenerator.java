package in.cg.IdGenerators;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

public class StudentGenerator implements IdentifierGenerator {

	@Override
	public Serializable generate(SharedSessionContractImplementor arg0, Object arg1) throws HibernateException {
		
		System.out.println("StudentGenerator.generate()");
		String date=new SimpleDateFormat("yyyy-mm-dd").format(new Date());
		int num=new Random().nextInt(1000);
		String prefix1="INeuron";
		String prefix2="HB";
		
		return prefix1+"-"+date+"-"+prefix2+"-"+num;
	}

}
