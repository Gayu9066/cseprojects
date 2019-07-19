#include<conio.h>
#include<stdlib.h>
#include<iostream>
#include<string.h>
#include<ctime>
using namespace std;
static int p=0;
static int q=0,r=0,s=0;
class reg
{
	public:
	char name[20],id[10];
	int age;
};

class cs:public reg
{
	protected:
		char course[5][3][30];
		int n1,count;
	public:
		void set()
		{
			cout<<"\n\n---WELCOME TO COMPUTER SCIENCE----"<<endl;
		}
	    friend	void assign();
		void show();
		void cancel();
}c[30],c1;

void assign()
{
	char subject[30];
	system("cls");
	cout<<"enter your name"<<endl;
	cin>>c[p].name;
	cout<<"enter your age"<<endl;
	cin>>c[p].age;
	cout<<"enter the id number "<<endl;
	cin>>c[p].id;
	cout<<"\n\n1.JAVA\n2.C++\n3.C programming\n4.phython\n5.php"<<endl;
	cout<<"enter the number of subjects you want to register"<<endl;
	cin>>c1.n1;
	cout<<"\n enter the subjects "<<endl;
	for(int i=0;i<1;i++)
	{
		for(int j=0;j<c1.n1;j++)
		{
			cin>>subject;
			strcpy(c[p].course[i][j],subject);
			c[p].count++;
		}
	}
	p++;
}
void cs:: show()
{
	int n,a=0,i,j;
	char number[10];
	system("cls");
	cout<<"enter the id number"<<endl;
	cin>>number;
	for(n=0;n<=p;n++)
	{
		if(strcmp(c[n].id,number)==0)
		break;
	}
	while(n<=p)
	{
		cout<<"\n\n\n\n";
		cout<<"----------------------------------"<<endl;
		cout<<"NAME:"<<c[n].name<<endl;
		cout<<"AGE:"<<c[n].age<<endl;
		cout<<"ID:"<<c[n].id<<endl;
		cout<<"COURSE:";
		for( i=0;i<1;i++)
		{
			for( j=0;j<c1.n1;j++)
			{
				if(strcmp(c[n].course[i][j],"empty")!=0)
				{
					a++;
					cout<<a<<"."<<c[n].course[i][j]<<endl;
					cout.width(8);
				}
			}
		}
		int res;
		for(i=0;i<1;i++)
		{
				int sum=c[n].count;
				for(j=0;j<sum;j++)
				{
						res=res+500;
				}
		}
		cout<<"\n price is: "<<res<<endl;
		cout<<"----------------------------------"<<endl;
		break;
	}
	if(n>p)
	{
		cout<<"enter correct id number"<<endl<<endl;
	}
}
void cs::cancel()
{
	char sub[30],number[10];
	int n;
	system("cls");
	cout<<"enter the subject you want to cancel"<<endl;
	cin>>sub;
	cout<<"enter the id number"<<endl;
	cin>>number;
	for(n=0;n<=p;n++)
	{
		if(strcmp(c[n].id,number)==0)
		{
	for(n=0;n<p;n++)
	{
		for(int i=0;i<1;i++)
		{
			for(int j=0;j<c1.n1;j++)
			{
				if(strcmp(c[n].course[i][j],sub)==0)
				{
					strcpy(c[n].course[i][j],"empty");
					c[n].count--;
					break;
				}
			}
		}
	}
	break;
}
}
	if(n>p)
	{
		cout<<" enter correct id number";
	}
}
class ec:public reg
{
	protected:
		char course[5][3][20];
		int n1,count;
	public:
	void set()
	{
		cout<<"----Welcome to ELECTRONICS branch----"<<endl;
	}
	friend void assign1();
	void show();
	void cancel();
}e[30],ec1;
void ec::cancel()
{
	char sub[30],number[10];
	int n;
	system("cls");
	cout<<"enter the subject you want to cancel"<<endl;
	cin>>sub;
	cout<<"enter the id number"<<endl;
	cin>>number;
	for(n=0;n<=q;n++)
	{
		if(strcmp(e[n].id,number)==0)
	{
	
	for(n=0;n<q;n++)
	{
		for(int i=0;i<1;i++)
		{
			for(int j=0;j<ec1.n1;j++)
			{
				if(strcmp(e[n].course[i][j],sub)==0)
				{
					strcpy(e[n].course[i][j],"empty");
					e[n].count--;
					break;
				}
			}
		}
	}
	break;
}
}
	
	if(n>q)
	{
		cout<<"enter the correct id name"<<endl;
	}
}

void assign1()
{
	char subject[30];
	cout<<"enter your name"<<endl;
	cin>>e[q].name;
	cout<<"enter your age"<<endl;
	cin>>e[q].age;
	cout<<"enter the id number "<<endl;
	cin>>e[q].id;
	cout<<"\n\n1.electro magnetic\n2.integrated circuits\n3.micro processor\n 4. computer architecture\n 5. modern measurement"<<endl;
	cout<<"\n\nenter the number of subjects you want to register"<<endl;
	cin>>ec1.n1;
	cout<<"\nenter the subjects"<<endl;
	for(int i=0;i<1;i++)
	{
		for(int j=0;j<ec1.n1;j++)
		{
			cin>>subject;
			strcpy(e[q].course[i][j],subject);
			e[q].count++;
		}
	}
	q++;
}
void ec:: show()
{
	int n,a=0,i,j;
	char number[10];
	system("cls");
	cout<<"enter the id number"<<endl;
	cin>>number;
	for(n=0;n<=q;n++)
	{
		if(strcmp(e[n].id,number)==0)
		break;
	}
	while(n<=p)
	{
		cout<<"\n\n\n\n";
		cout<<"----------------------------------"<<endl;
		cout<<"NAME:"<<e[n].name<<endl;
		cout<<"AGE:"<<e[n].age<<endl;
		cout<<"ID:"<<e[n].id<<endl;
		cout<<"COURSE:"<<endl;
		for( i=0;i<1;i++)
		{
			for( j=0;j<ec1.n1;j++)
			{
				if(strcmp(e[n].course[i][j],"empty")!=0)
				{
					a++;
					cout<<a<<"."<<e[n].course[i][j]<<endl;
					cout.width(8);
				}
			}
		}
		int res;
		for(i=0;i<1;i++)
		{
				int sum=e[n].count;
				for(j=0;j<sum;j++)
				{
						res=res+500;
				}
		}
		cout<<"\nprice is: "<<res<<endl;
		cout<<"----------------------------------"<<endl;
		break;
	}
	if(n>q)
	{
		cout<<"enter correct id number"<<endl;
	}
}

class  cv :public reg
{
	protected:
		char course[5][3][30];
		int n1,count;
	public:
		void set()
		{
			cout<<"\n---WELCOME TO CIVIL ENGINEERING"<<endl;
		}
	       friend	void assign2();
		void show();
		void cancel();
}ci[30],civ;
void cv::cancel()
{
	char sub[30],number[10];
	int n;
	system("cls");
	cout<<"enter the subject you want to cancel"<<endl;
	cin>>sub;
	cout<<"enter the id number"<<endl;
	cin>>number;
	for(n=0;n<=s;n++)
	{
		if(strcmp(ci[n].id,number)==0)
	{
	
	for(n=0;n<s;n++)
	{
		for(int i=0;i<1;i++)
		{
			for(int j=0;j<civ.n1;j++)
			{
				if(strcmp(ci[n].course[i][j],sub)==0)
				{
					strcpy(ci[n].course[i][j],"empty");
					ci[n].count--;
					break;
				}
			}
		}
	}
	break;
}
}
	
	if(n>s)
	{
		cout<<"enter the correct subject name"<<endl;
	}
}
void assign2()
{
	char subject[20];
	cout<<"enter your name"<<endl;
	cin>>ci[s].name;
	cout<<"enter your age"<<endl;
	cin>>ci[s].age;
	cout<<"enter the id number "<<endl;
	cin>>ci[s].id;
	cout<<"\n\n1.fluid mechanics\n2.envinormental engg\n3.fundamentals of soil\n4.structural design\n5.concrete technology"<<endl;
	cout<<"\nenter the number of subjects you want to register"<<endl;
	cin>>civ.n1;
	cout<<"\nenter the subjects"<<endl;
	for(int i=0;i<1;i++)
	{
		for(int j=0;j<civ.n1;j++)
		{
			cin>>subject;
			strcpy(ci[s].course[i][j],subject);
			ci[s].count++;
		}
	}
	s++;
}
void cv:: show()
{
	int n,a=0,i,j;
	char number[10];
	system("cls");
	cout<<"enter the id number"<<endl;
	cin>>number;
	for(n=0;n<=s;n++)
	{
		if(strcmp(ci[n].id,number)==0)
		break;
	}
	while(n<=s)
	{
		cout<<"\n\n\n\n";
		cout<<"----------------------------------"<<endl;
		cout<<"NAME:"<<ci[n].name<<endl;
		cout<<"AGE:"<<ci[n].age<<endl;
		cout<<"ID:"<<ci[n].id<<endl;
		cout<<"COURSE:";
		for( i=0;i<1;i++)
		{
			for( j=0;j<civ.n1;j++)
			{
				if(strcmp(ci[n].course[i][j],"empty")!=0)
				{
					a++;
					cout<<a<<"."<<ci[n].course[i][j]<<endl;
					cout.width(8);
				}
			}
		}
		int res;
		for(i=0;i<1;i++)
		{
				int sum=ci[n].count;
				for(j=0;j<sum;j++)
				{
						res=res+500;
				}
		}
		cout<<"\nprice is: "<<res<<endl;
		cout<<"----------------------------------"<<endl;
		break;
	}
	if(n>s)
	{
		cout<<"enter correct id number"<<endl;
	}
}

class ee:public reg
{
	protected:
		char course[5][3][30];
		int n1,count;
	public:
	void set()
	{
		cout<<"\n-----Welcome to EEE branch-----" ;
	}
	friend void assign3();
	void show();
	void cancel();
}e1[30],e2;
void ee::cancel()
{
	char sub[30],number[10];
	int n;
	system("cls");
	cout<<"enter the subject you want to cancel"<<endl;
	cin>>sub;
	cout<<"enter the id number"<<endl;
	cin>>number;
	for(n=0;n<=r;n++)
	{
		if(strcmp(e1[n].id,number)==0)
	{
	
	for(n=0;n<r;n++)
	{
		for(int i=0;i<1;i++)
		{
			for(int j=0;j<e2.n1;j++)
			{
				if(strcmp(e1[n].course[i][j],sub)==0)
				{
					strcpy(e1[n].course[i][j],"empty");
					e1[n].count--;
					break;
				}
			}
		}
	}
	break;
}
}
	if(n>r)
	{
		cout<<"enter the correct subject name"<<endl;
	}
}
void assign3()
{
	char subject[30];
	system("cls");
	cout<<"enter your name"<<endl;
	cin>>e1[r].name;
	cout<<"enter your age"<<endl;
	cin>>e1[r].age;
	cout<<"enter the id number "<<endl;
	cin>>e1[r].id;
	cout<<"\n\n1.electronic in power\n2.computer techniques in power\n3.electro magnetic interference\n4.control of electric drives\n5.advanced electrical"<<endl;
	cout<<"\nenter the number of subjects you want to register"<<endl;
	cin>>e2.n1;
	cout<<" enter the subjects"<<endl;
	for(int i=0;i<1;i++)
	{
		for(int j=0;j<e2.n1;j++)
		{
			cin>>subject;
			strcpy(e1[r].course[i][j],subject);
			e1[r].count++;
		}
	}
	r++;
}
void ee:: show()
{
	int n,a=0,i,j;
	char number[10];
	system("cls");
	cout<<"enter the id number"<<endl;
	cin>>number;
	for(n=0;n<=r;n++)
	{
		if(strcmp(e1[n].id,number)==0)
		break;
	}
	while(n<=r)
	{
		cout<<"\n\n\n\n";
		cout<<"----------------------------------"<<endl;
		cout<<"NAME:"<<ci[n].name<<endl;
		cout<<"AGE:"<<ci[n].age<<endl;
		cout<<"ID:"<<ci[n].id<<endl;
		cout<<"COURSE:";
		for( i=0;i<1;i++)
		{
			for( j=0;j<e2.n1;j++)
			{
				if(strcmp(e1[n].course[i][j],"empty")!=0)
				{
					a++;
					cout<<a<<"."<<e1[n].course[i][j]<<endl;
					cout.width(8);
				}
			}
		}
		int res;
		for(i=0;i<1;i++)
		{
				int sum=e1[n].count;
				for(j=0;j<sum;j++)
				{
						res=res+500;
				}
		}
		cout<<"price is: "<<res<<endl;
		cout<<"----------------------------------"<<endl;
		break;
	}
	if(n>r)
	{
		cout<<"enter correct id number"<<endl;
	}
}

class admin:public cs,public ec,public cv,public ee
{
	protected:
	char name[10];
	char passwd[10];
	public:
	virtual	void assign()
	{
		system("cls");
		cout<<"enter admin name"<<endl;
		cin>>name;
		cout<<"enter admin password"<<endl;
		cin>>passwd;
	}
}ad;
class user:public admin
{
	protected:
	char name[10];
	char passwd[10];
	public:
	void assign()
	{
		system("cls");
		cout<<"enter user name"<<endl;
		cin>>name;
		cout<<"enter user password"<<endl;
		cin>>passwd;
	}
};

int main()
{
	int ch,n,k=1,x;
	system("cls");
	system("color 0A");
	cout<<"$$--WELCOME TO COURSE REGISTRATION--$$"<<endl;
		//  FOR current time and date
	time_t now;	
	time (&now);
	cout<<ctime(&now)<<endl;         // For Displaying Date and Time	
	// Creating Object of Time
		
		cout<<"\n 1->ADMIN\n 2->USER"<<endl;
		cin>>x;
	if(x==1)
{
	admin *p;
	p=&ad;
	p->assign();		
	while(k)
	{
		l:
		cout<<"\nPLEASE SELECT YOUR BRANCH"<<endl;
		cout<<"\n1:CS\n2:EC\n3:CV\n4:EEE\n0-exit\n";
		cin>>n;
		if(n==1)
		{
			c1.set();
			cout<<endl;
			while(1)
			{
				cout<<"\n\n1.Assign\n2:show\n3.cancel\n4.Exit";
				cout<<"\nEnter your choice:-> ";
				cin>>ch;
				switch(ch)
				{
				case 1: assign();
				break;
				case 2:c[0].show();
				break;
				case 3: c[0].cancel();
				break;
				case 4: goto l;
				}
			}
		}
		if(n==2)
		{
			ec1.set();
			cout<<endl;
			while(1)
			{
				cout<<"\n\n1.Assign\n2:show\n3.cancel\n4.Exit";
				cout<<"\nEnter your choice:-> ";
				cin>>ch;
				switch(ch)
				{
				case 1: assign1();
					break;
				case 2: e[0].show();
					break;
				case 3:e[0].cancel();
					break;
				case 4: goto l;
				}
			}
		}
		if(n==3)
		{
			civ.set();
			cout<<endl;
			while(1)
			{
				cout<<"\n\n1.Assign\n2:show\n3.cancel\n4.Exit";
				cout<<"\nEnter your choice:-> ";
				cin>>ch;
				switch(ch)
				{
					case 1:assign2();
					break;
					case 2: ci[0].show();
					break;
					case 3:ci[0].cancel();
					break;
					case 4: goto l;
				}
			}
		}
		if(n==4)
		{
			e2.set();
			cout<<endl;
			while(1)
			{
				cout<<"\n\n1.Assign\n2:show\n3.cancel\n4.Exit";
				cout<<"\nEnter your choice:-> ";
				cin>>ch;
				switch(ch)
				{
					case 1: assign3();
					break;
					case 2: e1[0].show();
					break;
					case 3:e1[0].cancel();
						break;
					case 4: goto l;
				}
			}
		}
		if(n==0)
		{
			k=0;
		}
	}
}
	if(x==2)
{
	admin *p;
	user ud;
	p=&ud;
	p->assign();		
	while(k)
	{
		y:
		cout<<"\nPLEASE SELECT YOUR BRANCH"<<endl;
		cout<<"\n1:CS\n2:EC\n3:CV\n4:EEE\n0-exit\n";
		cin>>n;
		if(n==1)
		{
			c1.set();
			cout<<endl;
			while(1)
			{
				cout<<"\n\n1.Assign\n2:show\n3.cancel\n4.Exit";
				cout<<"\nEnter your choice:-> ";
				cin>>ch;
				switch(ch)
				{
				case 1: assign();
				break;
				case 2:c[0].show();
				break;
				case 3: c[0].cancel();
				break;
				case 4: goto y;
				}
			}
		}
		if(n==2)
		{
			ec1.set();
			cout<<endl;
			while(1)
			{
				cout<<"\n\n1.Assign\n2:show\n3.cancel\n4.Exit";
				cout<<"\nEnter your choice:-> ";
				cin>>ch;
				switch(ch)
				{
				case 1: assign1();
					break;
				case 2: e[0].show();
					break;
				case 3:e[0].cancel();
					break;
				case 4: goto y;
				}
			}
		}
		if(n==3)
		{
			civ.set();
			cout<<endl;
			while(1)
			{
				cout<<"\n\n1.Assign\n2:show\n3.cancel\n4.Exit";
				cout<<"\nEnter your choice:-> ";
				cin>>ch;
				switch(ch)
				{
					case 1:assign2();
					break;
					case 2: ci[0].show();
					break;
					case 3:ci[0].cancel();
					break;
					case 4: goto y;
				}
			}
		}
		if(n==4)
		{
			e2.set();
			cout<<endl;
			while(1)
			{
				cout<<"\n\n1.Assign\n2:show\n3.cancel\n4.Exit";
				cout<<"\nEnter your choice:-> ";
				cin>>ch;
				switch(ch)
				{
					case 1: assign3();
					break;
					case 2: e1[0].show();
					break;
					case 3:e1[0].cancel();
						break;
					case 4: goto y;
				}
			}
		}
		if(n==0)
		{
			k=0;
		}
	}
}
	return 0;
}
