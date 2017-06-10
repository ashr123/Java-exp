public class EditDistance
{
	public static int distanceMemo(String source, String target)
	{
		int[][] table=new int[source.length()+1][target.length()+1];
		for (int i=0; i<table.length; i=i+1)
			for (int j=0; j<table[i].length; j=j+1)
				table[i][j]=-1;
		return distanceMemo(source, target, table);
	}
	
	public static int distanceMemo(String source, String target, int[][] table)
	{
		int output;
		if (source.length()==0)
			output=target.length();
		else
			if (target.length()==0)
				output=source.length();
			else
			{
				if (table[source.length()][target.length()]==-1)
					if (source.charAt(0)==target.charAt(0))
						table[source.length()][target.length()]=
								distanceMemo(source.substring(1), target.substring(1), table);
					else
					{
						int substitution=distanceMemo(source.substring(1), target.substring(1), table);
						int deletion=distanceMemo(source.substring(1), target, table);
						int insertion=distanceMemo(source, target.substring(1), table);
						table[source.length()][target.length()]=
								1+Math.min(Math.min(substitution, deletion), insertion);
					}
				output=table[source.length()][target.length()];
			}
		return output;
	}
}