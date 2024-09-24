package fr.humanbooster.harrypotter.jsonviews;

public class Jsonviews {

    public interface showStudentSimple extends StudentJsonview.showStudentSimple, TypeClassJsonview.showTypeClassSimple, OffenseListJsonview.showOffenseListSimple{
    }

    public interface showStudentDetailed extends StudentJsonview.showStudentDetailed,TypeClassJsonview.showTypeClassDetailed {
    }
}
