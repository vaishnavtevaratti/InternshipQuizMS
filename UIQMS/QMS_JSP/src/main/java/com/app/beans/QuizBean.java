package com.app.beans;

import java.io.File;
import java.util.List;

import com.app.dao.*;
import com.app.model.*;
import com.app.util.QuestionFileParser;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data

public class QuizBean {

    private String title;
    private String filePath;
    private boolean status;
    private User user;
    
    private List<Quiz> qlist;

    private int quizId;
    

    public QuizBean(){
    	
    }

    public boolean createQuiz(){

    		try(QuizDao qd = new QuizDao()){

            Quiz quiz = new Quiz();
            quiz.title = title;
            quiz.creatorId = user.getId();

            int quizId = qd.insert(quiz);

            List<Questions> list = QuestionFileParser.parse(new File(filePath));

            try(QuestionsDao qdao = new QuestionsDao()){
                for(Questions q : list){
                    q.quizId = quizId;
                    qdao.insert(q);
                }
            }

            status = true;
        }
        catch(Exception e){
            e.printStackTrace();
            status = false;
        }

        return status;
    }
    
    public void listQuizzes() {
        try(QuizDao dao = new QuizDao()) {
            qlist = dao.listQuizzes();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }


    public String deleteQuiz() {
        try(QuizDao dao = new QuizDao()) {
            dao.deleteQuiz(quizId);
            return "Quiz Deleted Successfully";
        } catch (Exception e) {
            e.printStackTrace();
            return "Error";
        }
    }
}
