package batch;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import domain.Free;
import repository.FreeDAO;


public class FreeJob implements Job, Serializable {

	private static final long serialVersionUID = 1L;

	@Override
	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		
//		HttpServletRequest request;
//		request.getContextPath();
		Free topHitObj = FreeDAO.getInstance().topHitFree();
		System.out.println(topHitObj.toString());
		
		String filename = "../../jspstudy/BoardProject/top.txt";
		
		File file = new File(filename);
		BufferedOutputStream out = null;
		ObjectOutputStream oos = null;
		try {
			out  = new BufferedOutputStream(new FileOutputStream(file));
			oos = new ObjectOutputStream(out);
			oos.writeObject(topHitObj.toString());
			oos.close();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
