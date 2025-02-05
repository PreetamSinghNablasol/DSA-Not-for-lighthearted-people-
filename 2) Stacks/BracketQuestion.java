import java.util.Scanner;
class BracketQuestion
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your Brackets : ");
		String str = new String(sc.nextLine());

		StackArray<Character> stack = new StackArray<>(str.length());
		for(int i=0; i<str.length(); i++)
		{
			if(stack.getTop() != null && stack.getTop() == str.charAt(i))
			{
				stack.pop();
			}
			else
			{
				stack.push(str.charAt(i));
			}
		}
		if(stack.getSize() == 0)
		{
			System.out.println("Perfect");
		}
		else
		{
			System.out.println("Imperfect");
		}

	}
}
