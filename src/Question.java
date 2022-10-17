import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

public class Question implements Comparable<Question> {
	
	private String question;
	private String answer;
	private QuestionType questionType;

	public Question(String question, String answer, QuestionType questionType) {
		this.question = question;
		this.answer = answer;
		this.questionType = questionType;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}
	
	public QuestionType getQuestionType() {
		return questionType;
	}

	
//	public ArrayList<String> createAnswerList(int howManyAnswers) {
//		ArrayList<String> answerList = new ArrayList<>();
//		Random generator = new Random();
//
//		int lengthOfStateEnum = State.values().length;
//		System.out.println("length of Enum is " + lengthOfStateEnum);
//
//		// First put in the correct answer
//		answerList.add(answer);
//
//		// Then put in the random answers
//		for (int i = 1; i < howManyAnswers; i++) {
//			// Get random number between 0 and (length of enum - 1)
//			int randomNumber = generator.nextInt(lengthOfStateEnum - 1);
//			System.out.println("random number is - " + randomNumber);
//			System.out.println("question type is - " + questionType);
//
//			switch (questionType) {
//			case ABBREV:
//				answerList.add(State.values()[randomNumber].toString());
//				break;
//			case CAPITAL:
//				answerList.add(State.values()[randomNumber].getCapital());
//				break;
//			case MAP:
//				// to be added later .....
//				break;
//			default:
//				// should not happen as ENUM
//			}
//		}
//
//		// Shuffle up the answers
//		Collections.shuffle(answerList);
//
//		for (String s : answerList) {
//			System.out.println("\n" + s);
//		}
//
//		return answerList;
//	}
	
	//Use a Set so that there are no duplicates
	public Set<String> createAnswerSet(int howManyAnswers) {
		Set<String> answerSet = new TreeSet<>();
		Random generator = new Random();

		int lengthOfStateEnum = State.values().length;
		System.out.println("length of Enum is " + lengthOfStateEnum);

		// First put in the correct answer
		answerSet.add(answer);
		
		System.out.println("answerSet size " + answerSet.size());
		System.out.println("how Man yAnswers " + howManyAnswers);
		// Then put in the random answers
		while (answerSet.size() < howManyAnswers) {

			System.out.println("Going in ... ");
		
			// Get random number between 0 and (length of enum - 1)
			int randomNumber = generator.nextInt(lengthOfStateEnum - 1);
			System.out.println("random number is - " + randomNumber);
			System.out.println("question type is - " + questionType);

			switch (questionType) {
			case ABBREV:
				//answerSet.add(State.values()[randomNumber].toString());
				
				//Make up an Abbreviation that is a bit like the right answer!
				

				StringBuilder sb = new StringBuilder();
				sb.append(answer.charAt(0));
		//		System.out.println("Stringbuilder string1" + sb.toString());
				String copyQuestion = question.replaceAll("\\s", "");
				int randomLetter = generator.nextInt(copyQuestion.length() - 1);
				sb.append(copyQuestion.charAt(randomLetter));
		//		System.out.println("Stringbuilder string2" + sb.toString());
				answerSet.add(sb.toString().toUpperCase());
				break;
			case CAPITAL:
				answerSet.add(State.values()[randomNumber].getCapital());
				break;
			case MAP:
				answerSet.add(State.values()[randomNumber].toString() + ".jpg");
				break;
			default:
				// should not happen as ENUM
			}
		}

		// Shuffle up the answers - no need with a Set, as Set unordered
		//Collections.shuffle(answerSet);

		for (String s : answerSet) {
			System.out.println("\n" + s);
		}

		return answerSet;
	}

	@Override
	public boolean equals(Object otherObj) {
		if (otherObj instanceof Question) {
			Question otherQuestion = (Question) otherObj;
			
			String otherQQQuestion = otherQuestion.question;
			
			if (question.equalsIgnoreCase(otherQQQuestion))  {
				return true;
			} else {
				return false;
			}
			
		} else {
			return false;
		}
	}

	@Override
	public int compareTo(Question other) {

		return question.compareToIgnoreCase(other.question);

	}
	

	@Override
	public String toString() {
		String s = "Question : ";
		s +=  question;
		s += " Answer : " + answer;
		return s;
	}
	

}
