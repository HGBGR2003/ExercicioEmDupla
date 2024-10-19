package br.edu.ifgoiano.aluno.henrique;

public class MatchValues {
    private int id;
    private String text;
    private int positionStart;
    private int positionEnd;

    public MatchValues(int id, String text, int positionStart, int positionEnd) {
        this.id = id;
        this.text = text;
        this.positionStart = positionStart;
        this.positionEnd = positionEnd;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getPositionStart() {
        return positionStart;
    }

    public void setPositionStart(int positionStart) {
        this.positionStart = positionStart;
    }

    public int getPositionEnd() {
        return positionEnd;
    }

    public void setPositionEnd(int positionEnd) {
        this.positionEnd = positionEnd;
    }

    @Override
    public String toString() {
        return "MatchValues{" +
                "id=" + id +
                ", text='" + text + '\'' +
                ", positionStart=" + positionStart +
                ", positionEnd=" + positionEnd +
                '}';
    }

}
