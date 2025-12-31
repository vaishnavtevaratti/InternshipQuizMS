package com.app.beans;

import java.util.ArrayList;
import java.util.List;

import com.app.dao.AttemptDao;
import com.app.dao.QuestionsDao;
import com.app.model.Attempt;
import com.app.model.Questions;
import com.app.model.User;

public class AttemptBean {

    private List<Attempt> list;
    private User user;

    private int quizId;
    private int studentId;

    private List<Questions> questions = new ArrayList<>();
    private int score;
    private String error;

    private List<String> answers = new ArrayList<>();

    public AttemptBean(){}

    // ---------- QUIZ FLOW ----------

    public String takeQuiz(){
        try(AttemptDao ad = new AttemptDao()){
            if(ad.hasAttemptedAlready(studentId, quizId))
                return "already";
        } catch(Exception e){
            error = e.getMessage();
            return "error";
        }

        try(QuestionsDao qd = new QuestionsDao()){
            questions = qd.getQuestions(quizId);
        } catch(Exception e){
            error = e.getMessage();
            return "error";
        }

        return "showquiz";
    }

    public String submitQuiz(){
        try{
            score = 0;

            for(int i=0;i<questions.size();i++){
                String correct = String.valueOf(questions.get(i).getCorrect());
                // split user answer to remove index suffix: "A_0" → "A"
                String given = (i < answers.size() ? answers.get(i).split("_")[0] : "");
                if(correct.equalsIgnoreCase(given))
                    score++;
            }

            try(AttemptDao ad = new AttemptDao()){
                ad.recordAttempt(quizId, studentId, score, questions.size());
            }

            return "saved";
        } catch(Exception e){
            e.printStackTrace();
            error = e.getMessage();
            return "error";
        }
    }

    // ----------- SCORE VIEW METHODS -----------

    public void viewScoreAdmin(){
        try(AttemptDao ad = new AttemptDao()){
            this.list = ad.getAllAttempts();
        } catch(Exception e){
            e.printStackTrace();
        }
    }

    public void viewScoreStudent(){
        try(AttemptDao ad = new AttemptDao()){
            this.list = ad.getAteemptlist(user.getId());
        } catch(Exception e){
            e.printStackTrace();
        }
    }

    // ----------- JSP BINDING -----------

    public void setAnswers(String[] arr){
        answers.clear();
        if(arr != null){
            for(String s: arr)
                answers.add(s);
        }
    }

    public void setAnswers(List<String> answers){
        this.answers = answers;
    }

    // ----------- GETTERS & SETTERS -----------

    public int getQuizId(){ return quizId; }
    public void setQuizId(int quizId){ this.quizId = quizId; }

    public int getStudentId(){ return studentId; }
    public void setStudentId(int studentId){ this.studentId = studentId; }

    public List<Questions> getQuestions(){ return questions; }

    public int getScore(){ return score; }

    public String getError(){ return error; }

    public User getUser(){ return user; }
    public void setUser(User user){ this.user = user; }

    public List<String> getAnswers(){ return answers; }

    public List<Attempt> getList(){ return list; }
    public void setList(List<Attempt> list){ this.list = list; }
}
