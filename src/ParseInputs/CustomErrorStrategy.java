package ParseInputs;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.ATNState;
import org.antlr.v4.runtime.atn.ParserATNSimulator;
import org.antlr.v4.runtime.misc.IntervalSet;

public class CustomErrorStrategy extends DefaultErrorStrategy {

	@Override
	public void sync(Parser recognizer) throws RecognitionException {
		String ANSI_RED = "\u001B[31m";
		String ANSI_RESET = "\u001B[0m";
		System.out.print(ANSI_RED);
		ATNState s = (ATNState)((ParserATNSimulator)recognizer.getInterpreter()).atn.states.get(recognizer.getState());
		if(!this.inErrorRecoveryMode(recognizer)) {
			TokenStream tokens = recognizer.getInputStream();
			int la = tokens.LA(1);
			IntervalSet nextTokens = recognizer.getATN().nextTokens(s);
			if(!nextTokens.contains(-2) && !nextTokens.contains(la)) {
				switch(s.getStateType()) {
					case 3:
					case 4:
					case 5:
					case 10:
						if(this.singleTokenDeletion(recognizer) != null) {
							return;
						}

						throw new InputMismatchException(recognizer);
					case 9:
					case 11:
						this.reportUnwantedToken(recognizer);
						IntervalSet expecting = recognizer.getExpectedTokens();
						IntervalSet whatFollowsLoopIterationOrRule = expecting.or(this.getErrorRecoverySet(recognizer));
						this.consumeUntil(recognizer, whatFollowsLoopIterationOrRule);
					case 6:
					case 7:
					case 8:
					default:
				}
				System.out.print(ANSI_RESET);
				System.exit(1);
			}
		}

	}


}
