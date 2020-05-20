package Core;

import java.util.ArrayList;

import Core.Memory.Cell;

public class Memory
{
	public ArrayList<Cell> cells = new ArrayList<Cell>();

	public void DEBUGSETUP()
	{
		Cell c = new Cell("ad", true);
		cells.add(c);
		Cell D = new Cell("AFG", true);
		cells.add(D);
		Cell E = new Cell("FGDSAG", true);
		cells.add(E);
	}

	public void Remap()
	{
		for (int i = 1; i < cells.size(); i++)
		{
			if (cells.get(i) != null)
				cells.get(i - 1).Rewrite(cells.get(i).GetInformation());
		}
	}

	public void Delete(int index)
	{
		if(index < cells.size())
			cells.set(index, null);
	}

	public class Cell
	{
		private String information;

		private boolean rewritable;

		public String GetInformation()
		{
			return information;
		}

		public boolean IsRewritable()
		{
			return rewritable;
		}

		public void Rewrite(String newS)
		{
			if (rewritable)
				information = newS;
			else
				System.out.println("Cannot rewrite this cell \n(This cell is marked as non-rewriteble)");
		}

		public String toString() {
			return information + "\n";
		}
		
		
		public Cell(String t, boolean rw)
		{
			information = t;
			rewritable = rw;
		}

	}

}
