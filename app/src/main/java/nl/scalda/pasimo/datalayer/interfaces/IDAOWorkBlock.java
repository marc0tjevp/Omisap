
package nl.scalda.pasimo.datalayer.interfaces;

import java.util.Set;

import nl.scalda.pasimo.model.timeregistration.WorkBlock;

public interface IDAOWorkBlock {

	public void update(WorkBlock workBlock);

	public void create(WorkBlock workBlock);

	public void delete(WorkBlock workBlock);

	public WorkBlock read(int id);

	public Set<WorkBlock> readAll();
}