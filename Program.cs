using System;
using System.Collections.Generic;

class table
{
    public class Main_b<T>
    {
        private List<T> list;

        public Main_b()
        {
            this.list = new List<T>();
        }

        public void AddToCollection(T item)
        {
            list.Add(item);
        }

        public void RemoveFromCollection(T item)
        {
            list.Remove(item);
        }

        public T GetElementByIndex(int index)
        {
            if (index >= 0 && index < list.Count)
            {
                return list[index];
            }
            return default(T);
        }

        public int GetCollectionLength()
        {
            return list.Count;
        }

        public void PushToStack(T item)
        {
            if (list is Stack<T>)
            {
                (list as Stack<T>).Push(item);
            }
        }

        public T PopFromStack()
        {
            if (list is Stack<T> && list.Count > 0)
            {
                return (list as Stack<T>).Pop();
            }
            return default(T);
        }

        // For Queue
        public void Enqueue(T item)
        {
            if (list is Queue<T>)
            {
                (list as Queue<T>).Enqueue(item);
            }
        }

        public T Dequeue()
        {
            if (list is Queue<T> && list.Count > 0)
            {
                return (list as Queue<T>).Dequeue();
            }
            return default(T);
        }
    }
}

class Program
{
    public static void Main(string[] args)
    {
        // Example usage
        table.Main_b<int> genericCollection = new table.Main_b<int>();

        genericCollection.AddToCollection(1);
        genericCollection.AddToCollection(2);
        genericCollection.AddToCollection(3);

        Console.WriteLine("Collection length: " + genericCollection.GetCollectionLength());

        Console.WriteLine("Element at index 1: " + genericCollection.GetElementByIndex(1));

        // Example usage for Stack
        genericCollection.PushToStack(4);
        Console.WriteLine("Popped from stack: " + genericCollection.PopFromStack());

        // Example usage for Queue
        genericCollection.Enqueue(5);
        Console.WriteLine("Dequeued from queue: " + genericCollection.Dequeue());
    }
}
