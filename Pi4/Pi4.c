#include "./GPIO.h"
#include "./spi.h"

#include <string.h>
#include <arpa/inet.h>
#include <sys/socket.h>
#include <pthread.h>


#define IN 0
#define OUT 1
#define LOW 0
#define HIGH 1
#define VALUE_MAX 256
#define DIRECTION_MAX 45

#define BUTTON 19
#define BUTTON2 26

// button 사용 전 초기화
void button_init()
{
	//Enable GPIO pins
	if (-1 == GPIOExport(BUTTON) || -1 == GPIOExport(BUTTON2))
		exit(1);

	//Set GPIO directions
	if (-1 == GPIODirection(BUTTON, OUT) || -1 == GPIODirection(BUTTON2, IN))
		exit(1);
}

// button thread
void *button_thread(void *data)
{
	int state = 0;
	int button_state = 1;

	button_init();
	while (1)
	{
		if (-1 == GPIOWrite(BUTTON, 1))
			exit(1);

		while (GPIORead(BUTTON2) == button_state)
			continue;
		button_state ^= 1;

		if (button_state)
		{
			printf("fliped!\n");
			mode_flag ^= 1;
		}

		usleep(10000);
	}

	if(-1 == GPIOUnexport(POUT) || -1 == GPIOUnexport(PIN)){
        return;
	}
	exit(0);
}



#include "preSensor.h"
/*
static int prepare(int fd){
    if(ioctl(fd,SPI_IOC_WR_MODE, &MODE) == -1){
        perror("Can't set MODE");
        return -1;
    }

    if(ioctl(fd,SPI_IOC_WR_BITS_PER_WORD, &BITS) == -1){
        perror("Can't set number of BITS");
        return -1;
    }

    if(ioctl(fd, SPI_IOC_WR_MAX_SPEED_HZ,&CLOCK)==-1){
        perror("Can't set write CLOCK");
        return -1;
    }

    if(ioctl(fd, SPI_IOC_RD_MAX_SPEED_HZ, &CLOCK)==-1){
        perror("Can't set read CLOCK");
        return -1;
    }

    return 0;
}

uint8_t control_bits_differential(uint8_t channel){
    return (channel & 7) << 4;
}

uint8_t control_bits(uint8_t channel){
    return 0x8 | control_bits_differential(channel);
}

int readadc(int fd, uint8_t channel){
    uint8_t tx[] = {1, control_bits(channel),0};
    uint8_t rx[3];

    struct spi_ioc_transfer tr = {
        .tx_buf = (unsigned long)tx,
        .rx_buf = (unsigned long)rx,
        .len = ARRAY_SIZE(tx),
        .delay_usecs = DELAY,
        .speed_hz = CLOCK,
        .bits_per_word = BITS,
    };

    if(ioctl(fd, SPI_IOC_MESSAGE(1), &tr) == 1){
        perror("IO Error");
        abort();
    }

    return((rx[1] << 8) & 0x300) | (rx[2] & 0xFF);
}
*/
/*int pressure_sensor(int fd){
    int result = 1;       
    result=readadc(fd,1);
    return result;
}*/

void *pressure_thread(){
	int state=0;
	int emergency=0;
	int pressure=0;

	int fd = open(DEVICE, O_RDWR);

    if(fd <= 0){
        printf("Device &s not found\n", DEVICE);
        exit(0);
    }

    if(prepare(fd) == -1){
        printf("Device is not prepared\n");
        exit(0);
    }

	while(1){
		pressure=readadc(fd, 0);
		if(pressure >= 200){
			state = 1;
			printf("pressure value: %d\n", pressure);
		}
		else
			state = 0;

	}
	close(fd);
}



int main(int argc, char *argv[])
{
	// thread init
	pthread_t p_thread[2];
	int thr_id, status;
	char p1[] = "button";
	char p2[] = "pressure";

	if (argc != 3)
	{
		printf("Usage : %s <IP> <port>\n", argv[0]);
		exit(1);
	}

	thr_id = pthread_create(&p_thread[0], NULL, button_thread, (void *)p1);
	thr_id = pthread_create(&p_thread[1], NULL, pressure_thread, (void *)p2);

	pthread_join(p_thread[0], (void **)&status);
	pthread_join(p_thread[1], (void **)&status);

	return_resource();

	return 0;
}
