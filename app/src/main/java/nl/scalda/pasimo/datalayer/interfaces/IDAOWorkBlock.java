
package nl.scalda.pasimo.datalayer.interfaces;

import java.util.Set;

import nl.scalda.pasimo.model.timeregistration.WorkBlock;

public interface IDAOWorkBlock {

	public void update(WorkBlock workblock);

	public void create(WorkBlock workblock);

	public void delete(WorkBlock workblock);

	public WorkBlock read(int id);

	public Set<WorkBlock> readAll();
}