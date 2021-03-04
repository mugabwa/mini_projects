import java.util.Random;    //Java packet for random generator
public class Min_Heap {
    private final int []Tree;   //The heap array
    private int tree_lenght;    //The number of items in the array
    private final int capacity; //Total maximum of the array
     
    private Min_Heap(int capacity, int []values){   //Constructor
        this.capacity = capacity;
        this.tree_lenght = 0;
        Tree = new int[this.capacity + 1];
        Tree[0] = Integer.MIN_VALUE;
        // Initializing array values to the heap array
        for(int i = 0; i < values.length; i++){
            this.push_value(values[i]);
        }
    }
    
    //Returns the parent index
    private int location_parent_node(int index){
        return index / 2;
    }
    
    //Find the left child index
    private int location_left_child(int index){
        return 2 * index;
    }
    
    //Returns the right child
    private int location_right_child(int index){
        return (2 * index) + 1;
    }
    
    //Check is a value is a leaf node
    private boolean check_leaf_node(int index){
        if (index >= (tree_lenght / 2) && index <= tree_lenght) {
            return true;
        }else{
            return false;
        }
    }
    
    //Swap the nodes of the array
    private void change_nodes(int final_index, int start_index){
        int holder = Tree[final_index];
        Tree[final_index] = Tree[start_index];
        Tree[start_index] = holder;
    }
    
    //Min heap formation process and recursion
    private void create_min_heap(int index){
        int min_index;
        int leftindex = location_left_child(index);
        int rightindex = location_right_child(index);
        if (rightindex >= tree_lenght) {
            if (leftindex >= tree_lenght) {
                return;
            }else{
                min_index = leftindex;
            }
        }else{
            if (Tree[leftindex] <= Tree[rightindex]) {
                min_index = leftindex;
            }else{
                min_index = rightindex;
            }
        }
        if (Tree[index] >= Tree[min_index]) {
            change_nodes(min_index, index);
            create_min_heap(min_index); //Recursion
        }
    }
    
    //Insert an element into the heap
    private void push_value(int value){
        if (tree_lenght >= capacity) {
            return;
        }else{
            Tree[++tree_lenght] = value;
            int tree_size = tree_lenght;
            while (Tree[tree_size] < Tree[location_parent_node(tree_size)]) {                
                change_nodes(tree_size, location_parent_node(tree_size));
                tree_size = location_parent_node(tree_size);
            }
        }
        
    }
    
    //Print the values in the min-heap
    public void display(){
        System.out.println("  PARENT\tLEFT_CHILD\tRIGHT_CHILD");
        System.out.println("INDEX\tVALUE\tINDEX\tVALUE\tINDEX\tVALUE");
        for (int i = 1; i <= tree_lenght / 2; i++){
            System.out.print(i-1 + "\t" + Tree[i]);
            //Print if the value exists
            if((2*i)<= tree_lenght){
                System.out.print(" \t" + (2 * i-1) + "\t" + Tree[2 * i ]);
            }
            //Print if the value exists
            if(2*i+1<= tree_lenght){
                System.out.println("\t" + (2*i) + "\t" + Tree[2*i+1]);
            }
        }
    }
    
    //Remove an element form a specific index
    public void pop_node(int index){
        Tree[index+1] = Tree[tree_lenght--];
        Heapify();
    }
    
    // Organize the elements in the min-heap
    public void Heapify(){
        for (int index = (tree_lenght / 2); index >= 1; index--){
            create_min_heap(index);
        }
    }
    
    //Generates a random index
    public int random_index(){
        Random rand = new Random();
        return rand.ints(0,(tree_lenght)).findFirst().getAsInt();
    }
    
    //Modify the root value
    public void modify_root(int val){
        Tree[1] = Tree[1] + val;
        Heapify();
    }
    
    //Modify a specified element
    public void modify_element(int val, int update){
        for(int x=0; x<tree_lenght; x++){
            if(Tree[x+1] == val){
                Tree[x+1] = update;
            }
        }
        Heapify();
    }
    
    //Implements the delete-min algorithm
    public void delete_min(){
        Tree[1] = Tree[tree_lenght - 1];
        tree_lenght--;
        for(int x = 0; x < Tree.length-3; x++){
            int val = Tree[x];
            for (int y=x+1; y<Tree.length; y++){
                if(val == Tree[y]){
                    Tree[y] = Tree[y+1];
                    break;
                }
            }
        }
        if(tree_lenght>1){
            create_min_heap(1);
        }
    }
    
    
    
    // The main function
    public static void main(String[] args) {
        int input[] = { 23, 53, 64, 5, 87, 32, 50, 90, 14, 41}; //input array
        Min_Heap hp = new Min_Heap(20, input);  //Instanciate the object of the class
        hp.Heapify();   //Create a min-heap
        hp.display();   //Prints the min-heap
        
        //Implement the code for inserting the values 44, and then 20 into the min-heap.
        System.out.println("\nInsert element 44 and 20");
        hp.push_value(44);
        hp.push_value(20);
        hp.display();
        
        //Select a random integer in the range [0, array_size-1]. Delete the heap element at that heap
        // index and apply the necessary steps to maintain the min-heap property.
        System.out.println("\n");
        int pop = hp.random_index();
        System.out.println("\nElement removed at index: " + pop);
        hp.pop_node(pop);
        hp.display();
        
        //Increase the value of the root element to 25.
        System.out.println("\n Root modified by increment of 25");
        hp.modify_root(25);
        hp.display();
        
        //Change the value of the element with value 50 to 0.
        System.out.println("\n 50 modified by to 0");
        hp.modify_element(50, 0);
        hp.display();
        
        //Implement the delete-min algorithm on the heap.
        System.out.println("\n Delete min algorithm is applied");
        hp.delete_min();
        hp.display();
    }
}
