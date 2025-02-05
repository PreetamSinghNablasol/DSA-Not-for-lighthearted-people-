class MainClass
{
	public static void main(String... args)
	{
		Rotation rot = new Rotation();
		int[][] arr = {
			{00,01,02,03,04},
			{10,11,12,13,14},
			{20,21,22,23,24},  
			{30,31,32,33,34},  
			{40,41,42,43,44}
		};

		int[][] arr2 = rot.solution(arr);

		for(int[] i: arr2)
		{
			for(int j : i)
			{
				System.out.print(" "+j);
			}
			System.out.println();
		}
	}
}