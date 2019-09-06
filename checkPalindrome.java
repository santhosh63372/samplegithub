import java.util.*;
class Node
{
    int data;
    Node next;
}
public class llist
{
    Node head;
    Node CN(int data)
    {
        Node n=new Node();
        n.data=data;
        n.next=null;
        return n;
    }
    void insert(int data)
    {
        Node node=CN(data);
        if(head==null)
        {
           head=node;
        }
        else
        {
            Node p=head;
            while(p.next!=null)
            {
                p=p.next;
            }
            p.next=node;
        }
    } 
    void createLoop()
    {
        Node p=head;
        while(p.next!=null)
        {
            p=p.next;
        }
        p.next=head.next.next;
    }
    void print()
    {
        Node p=head;
        while(p!=null)
        {
            System.out.println(p.data);
            p=p.next;
        }
    }
    void detectLoop()
    {
        Node p=head;
        Node n=head;
        int i=1;
        HashSet<Node> hm=new HashSet<Node>();
        while(p!=null)
        {
            
            if(hm.contains(p))
            {
                System.out.println("Loop detected"+p.data+" "+i);
               // Node n=hm.get(i-1);
                
                n.next=null;
                print();
                break;
            }
            else
            {
                i++;
                hm.add(p);
                n=p;
                p=p.next;
            }
        }
    } 
    void starting()
    {
        Node fp=loop();
        Node sp=head;
        Node n=fp;
        while(sp!=fp)
        {
            n=fp;
            sp=sp.next;
            fp=fp.next;
        }
        System.out.println(n.data);
        n.next=null;
        System.out.println(sp.data);
        print();
    }
    Node loop()
    {
        Node fp=head,sp=head;
        while(fp!=null&&fp.next!=null)
        {
            sp=sp.next;
            fp=fp.next.next;
            if(fp==sp)
            {
                System.out.println(sp.data);
                return sp;
            }
        }
        return null;
    }
    Node reverse(Node h)
    {
        //Node h=head;
        Node p=null;
        Node t;
        while(h!=null)
        {
            t=h.next;
            h.next=p;
            p=h;
            h=t;
        }
        //printReverse(p);
        return p;    
        
    }
    void printReverse(Node h)
    {
        while(h!=null)
        {
            System.out.print(h.data+" ");
            h=h.next;
        }
        
    }
    void checkPalindrome()
    {
        
        Node h=head;
        Node sp=head,fp=head;
        while(fp!=null&&fp.next!=null)
        {
            sp=sp.next;
            fp=fp.next.next;
        }
        Node rev=reverse(sp.next);
        sp.next=null;
        while(rev!=null&&rev.data==h.data)
        {
            h=h.next;
            rev=rev.next;
        }
        if(rev==null)
        {
            System.out.println("Palindrome");
        }
        else
        {
            System.out.println("Not a palindrome");
        }
    }
    public static void main(String args[])
    {
        llist list=new llist();
        list.insert(10);
        list.insert(20);
        list.insert(23);
        list.insert(30);
        list.insert(10);
        //list.createLoop();
        //list.detectLoop();
        //list.print();
        //list.starting();
        //list.print();
        //list.reverse();
        list.checkPalindrome();
    }
} 


