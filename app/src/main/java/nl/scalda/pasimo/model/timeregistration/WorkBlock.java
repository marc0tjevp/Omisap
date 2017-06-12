package nl.scalda.pasimo.model.timeregistration;

import java.util.GregorianCalendar;

import javax.print.attribute.standard.DateTimeAtCompleted;

public class WorkBlock implements Comparable<WorkBlock> {

	private int workblockId;
	private PasimoTime start;
	private PasimoTime end;

	public WorkBlock() {

	}

	public WorkBlock(int workblockId, PasimoTime start, PasimoTime end) {
		this.start = start;
		this.end = end;
		this.workblockId = workblockId;
	}

	public int getworkblockId() {
		return workblockId;
	}

	public void setId(int workblockId) {
		this.workblockId = workblockId;
	}



	public PasimoTime getStart() {
		return start;
	}

	public void setStart(PasimoTime start) {
		this.start = start;
	}

	public PasimoTime getEnd() {
		return end;
	}

	public void setEnd(PasimoTime end) {
		this.end = end;
	}

	@Override
	public String toString() {
        return "WorkBlock{" +
        		"workblockId='" + workblockId + '\'' +
                "start='" + start + '\'' +               ", end='" + end + '\'' +
                '}';
   }

	@Override
	public int compareTo(WorkBlock o) {
		
		return this.start.compareTo(o.getStart());
	}

}