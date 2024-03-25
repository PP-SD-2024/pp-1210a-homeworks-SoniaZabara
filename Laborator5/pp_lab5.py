#!/usr/bin/python3
import tkinter as tk
import tkinter.ttk as ttk


class PpPrbl1App:
    def __init__(self, master=None):
        # build ui
        frame1 = ttk.Frame(master)
        frame1.configure(height=200, width=200)

        label1 = ttk.Label(frame1)
        label1.configure(text='List of integers:  ')
        label1.grid(column=0, row=0)

        entry1 = ttk.Entry(frame1)
        entry1.grid(column=1, row=0)

        e_text="results?"

        def get_value():
            e_text=entry1.get()
            text1.delete('1.0',tk.END)
            text1.insert(tk.END,e_text)
            
        button1 = ttk.Button(frame1,command=get_value)
        button1.configure(text='Add list')
        button1.grid(column=2, row=0)

        def odd(x):
            return x%2==1

        def filter_odd():
            e_text=entry1.get()
            text1.delete('1.0',tk.END)
            rez=[int(i) for i in e_text.split() if i.isdigit()]
            rezult=filter(odd,rez)
            text1.insert(tk.END,list(rezult))

        button2 = ttk.Button(frame1,command=filter_odd)
        button2.configure(text='Filter odd')
        button2.grid(column=2, row=1)

        def prime(x):
            if x==0:
                return False
            if x==1:
                return False
            for i in range(2,x):
                if x%2==0:
                    return False
            return True

        def filter_primes():
            e_text=entry1.get()
            text1.delete('1.0',tk.END)
            rez=[int(i) for i in e_text.split() if i.isdigit()]
            rezult=filter(prime,rez)
            text1.insert(tk.END,list(rezult))

        button3 = ttk.Button(frame1)
        button3.configure(text='Filter primes',command=filter_primes)
        button3.grid(column=2, row=2)

        button4 = ttk.Button(frame1)
        button4.configure(text='Sum num')
        button4.grid(column=2, row=3)

        text1 = tk.Text(frame1)
        text1.configure(height=10, width=50)
        text1.grid(column=1, row=1)

        text1.insert(tk.END,e_text)

        frame1.pack(side="top")

        # Main widget
        self.mainwindow = frame1

    def run(self):
        self.mainwindow.mainloop()


if __name__ == "__main__":
    root = tk.Tk()
    app = PpPrbl1App(root)
    app.run()
