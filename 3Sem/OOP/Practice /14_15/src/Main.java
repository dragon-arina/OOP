
public class Main  {
    public static void main(String[] args){
        FirstTask firstTask = new FirstTask();
        firstTask.Init();
            firstTask.Add("England", "London");
            firstTask.Add("Russia", "Moscow");
            firstTask.Add("Brazil", "Brazil");
            firstTask.Add("France", "Paris");
            firstTask.Add("Italian", "Milan");
            firstTask.Add("Japan", "Tokyo");
            firstTask.Add("Korea", "Soul");
            firstTask.Add("Norway", "Oslo");
            firstTask.Add("Scotland", "Edinburgh");
            firstTask.Add("Ireland", "Dublin");

        System.out.println(firstTask.LookUp("Japan"));

        firstTask.Delete("Brazil", "Brazil");
        System.out.println(firstTask.LookUp("Brazil"));
    }
}
