package meldexun.matrixutil;

import java.nio.FloatBuffer;

import org.lwjgl.MemoryUtil;

import net.minecraft.util.math.MathHelper;
import sun.misc.Unsafe;

public class Matrix4f {

	public float m00;
	public float m01;
	public float m02;
	public float m03;
	public float m10;
	public float m11;
	public float m12;
	public float m13;
	public float m20;
	public float m21;
	public float m22;
	public float m23;
	public float m30;
	public float m31;
	public float m32;
	public float m33;

	public Matrix4f() {

	}

	public Matrix4f(Matrix4f matrix) {
		this.m00 = matrix.m00;
		this.m01 = matrix.m01;
		this.m02 = matrix.m02;
		this.m03 = matrix.m03;
		this.m10 = matrix.m10;
		this.m11 = matrix.m11;
		this.m12 = matrix.m12;
		this.m13 = matrix.m13;
		this.m20 = matrix.m20;
		this.m21 = matrix.m21;
		this.m22 = matrix.m22;
		this.m23 = matrix.m23;
		this.m30 = matrix.m30;
		this.m31 = matrix.m31;
		this.m32 = matrix.m32;
		this.m33 = matrix.m33;
	}

	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		} else if (obj != null && this.getClass() == obj.getClass()) {
			Matrix4f matrix4f = (Matrix4f) obj;
			return Float.compare(matrix4f.m00, this.m00) == 0
					&& Float.compare(matrix4f.m01, this.m01) == 0
					&& Float.compare(matrix4f.m02, this.m02) == 0
					&& Float.compare(matrix4f.m03, this.m03) == 0
					&& Float.compare(matrix4f.m10, this.m10) == 0
					&& Float.compare(matrix4f.m11, this.m11) == 0
					&& Float.compare(matrix4f.m12, this.m12) == 0
					&& Float.compare(matrix4f.m13, this.m13) == 0
					&& Float.compare(matrix4f.m20, this.m20) == 0
					&& Float.compare(matrix4f.m21, this.m21) == 0
					&& Float.compare(matrix4f.m22, this.m22) == 0
					&& Float.compare(matrix4f.m23, this.m23) == 0
					&& Float.compare(matrix4f.m30, this.m30) == 0
					&& Float.compare(matrix4f.m31, this.m31) == 0
					&& Float.compare(matrix4f.m32, this.m32) == 0
					&& Float.compare(matrix4f.m33, this.m33) == 0;
		} else {
			return false;
		}
	}

	public int hashCode() {
		int i = this.m00 != 0.0F ? Float.floatToIntBits(this.m00) : 0;
		i = 31 * i + (this.m01 != 0.0F ? Float.floatToIntBits(this.m01) : 0);
		i = 31 * i + (this.m02 != 0.0F ? Float.floatToIntBits(this.m02) : 0);
		i = 31 * i + (this.m03 != 0.0F ? Float.floatToIntBits(this.m03) : 0);
		i = 31 * i + (this.m10 != 0.0F ? Float.floatToIntBits(this.m10) : 0);
		i = 31 * i + (this.m11 != 0.0F ? Float.floatToIntBits(this.m11) : 0);
		i = 31 * i + (this.m12 != 0.0F ? Float.floatToIntBits(this.m12) : 0);
		i = 31 * i + (this.m13 != 0.0F ? Float.floatToIntBits(this.m13) : 0);
		i = 31 * i + (this.m20 != 0.0F ? Float.floatToIntBits(this.m20) : 0);
		i = 31 * i + (this.m21 != 0.0F ? Float.floatToIntBits(this.m21) : 0);
		i = 31 * i + (this.m22 != 0.0F ? Float.floatToIntBits(this.m22) : 0);
		i = 31 * i + (this.m23 != 0.0F ? Float.floatToIntBits(this.m23) : 0);
		i = 31 * i + (this.m30 != 0.0F ? Float.floatToIntBits(this.m30) : 0);
		i = 31 * i + (this.m31 != 0.0F ? Float.floatToIntBits(this.m31) : 0);
		i = 31 * i + (this.m32 != 0.0F ? Float.floatToIntBits(this.m32) : 0);
		return 31 * i + (this.m33 != 0.0F ? Float.floatToIntBits(this.m33) : 0);
	}

	public String toString() {
		StringBuilder stringbuilder = new StringBuilder();
		stringbuilder.append("Matrix4f:\n");
		stringbuilder.append(this.m00);
		stringbuilder.append(" ");
		stringbuilder.append(this.m01);
		stringbuilder.append(" ");
		stringbuilder.append(this.m02);
		stringbuilder.append(" ");
		stringbuilder.append(this.m03);
		stringbuilder.append("\n");
		stringbuilder.append(this.m10);
		stringbuilder.append(" ");
		stringbuilder.append(this.m11);
		stringbuilder.append(" ");
		stringbuilder.append(this.m12);
		stringbuilder.append(" ");
		stringbuilder.append(this.m13);
		stringbuilder.append("\n");
		stringbuilder.append(this.m20);
		stringbuilder.append(" ");
		stringbuilder.append(this.m21);
		stringbuilder.append(" ");
		stringbuilder.append(this.m22);
		stringbuilder.append(" ");
		stringbuilder.append(this.m23);
		stringbuilder.append("\n");
		stringbuilder.append(this.m30);
		stringbuilder.append(" ");
		stringbuilder.append(this.m31);
		stringbuilder.append(" ");
		stringbuilder.append(this.m32);
		stringbuilder.append(" ");
		stringbuilder.append(this.m33);
		stringbuilder.append("\n");
		return stringbuilder.toString();
	}

	public void store(FloatBuffer buf) {
		Unsafe unsafe = UnsafeUtil.instance();

		if (unsafe != null) {
			long addr = MemoryUtil.getAddress(buf);
			unsafe.putFloat(addr + 0, this.m00);
			unsafe.putFloat(addr + 4, this.m10);
			unsafe.putFloat(addr + 8, this.m20);
			unsafe.putFloat(addr + 12, this.m30);
			unsafe.putFloat(addr + 16, this.m01);
			unsafe.putFloat(addr + 20, this.m11);
			unsafe.putFloat(addr + 24, this.m21);
			unsafe.putFloat(addr + 28, this.m31);
			unsafe.putFloat(addr + 32, this.m02);
			unsafe.putFloat(addr + 36, this.m12);
			unsafe.putFloat(addr + 40, this.m22);
			unsafe.putFloat(addr + 44, this.m32);
			unsafe.putFloat(addr + 48, this.m03);
			unsafe.putFloat(addr + 52, this.m13);
			unsafe.putFloat(addr + 56, this.m23);
			unsafe.putFloat(addr + 60, this.m33);
		} else {
			buf.put(0, this.m00);
			buf.put(1, this.m10);
			buf.put(2, this.m20);
			buf.put(3, this.m30);
			buf.put(4, this.m01);
			buf.put(5, this.m11);
			buf.put(6, this.m21);
			buf.put(7, this.m31);
			buf.put(8, this.m02);
			buf.put(9, this.m12);
			buf.put(10, this.m22);
			buf.put(11, this.m32);
			buf.put(12, this.m03);
			buf.put(13, this.m13);
			buf.put(14, this.m23);
			buf.put(15, this.m33);
		}
	}

	public void load(FloatBuffer buf) {
		Unsafe unsafe = UnsafeUtil.instance();

		if (unsafe != null) {
			long addr = MemoryUtil.getAddress(buf);
			this.m00 = unsafe.getFloat(addr);
			this.m10 = unsafe.getFloat(addr + 4);
			this.m20 = unsafe.getFloat(addr + 8);
			this.m30 = unsafe.getFloat(addr + 12);
			this.m01 = unsafe.getFloat(addr + 16);
			this.m11 = unsafe.getFloat(addr + 20);
			this.m21 = unsafe.getFloat(addr + 24);
			this.m31 = unsafe.getFloat(addr + 28);
			this.m02 = unsafe.getFloat(addr + 32);
			this.m12 = unsafe.getFloat(addr + 36);
			this.m22 = unsafe.getFloat(addr + 40);
			this.m32 = unsafe.getFloat(addr + 44);
			this.m03 = unsafe.getFloat(addr + 48);
			this.m13 = unsafe.getFloat(addr + 52);
			this.m23 = unsafe.getFloat(addr + 56);
			this.m33 = unsafe.getFloat(addr + 60);
		} else {
			this.m00 = buf.get(0);
			this.m10 = buf.get(1);
			this.m20 = buf.get(2);
			this.m30 = buf.get(3);
			this.m01 = buf.get(4);
			this.m11 = buf.get(5);
			this.m21 = buf.get(6);
			this.m31 = buf.get(7);
			this.m02 = buf.get(8);
			this.m12 = buf.get(9);
			this.m22 = buf.get(10);
			this.m32 = buf.get(11);
			this.m03 = buf.get(12);
			this.m13 = buf.get(13);
			this.m23 = buf.get(14);
			this.m33 = buf.get(15);
		}
	}

	public void setIdentity() {
		this.m00 = 1.0F;
		this.m01 = 0.0F;
		this.m02 = 0.0F;
		this.m03 = 0.0F;
		this.m10 = 0.0F;
		this.m11 = 1.0F;
		this.m12 = 0.0F;
		this.m13 = 0.0F;
		this.m20 = 0.0F;
		this.m21 = 0.0F;
		this.m22 = 1.0F;
		this.m23 = 0.0F;
		this.m30 = 0.0F;
		this.m31 = 0.0F;
		this.m32 = 0.0F;
		this.m33 = 1.0F;
	}

	public float adjugateAndDet() {
		float f = this.m00 * this.m11 - this.m01 * this.m10;
		float f1 = this.m00 * this.m12 - this.m02 * this.m10;
		float f2 = this.m00 * this.m13 - this.m03 * this.m10;
		float f3 = this.m01 * this.m12 - this.m02 * this.m11;
		float f4 = this.m01 * this.m13 - this.m03 * this.m11;
		float f5 = this.m02 * this.m13 - this.m03 * this.m12;
		float f6 = this.m20 * this.m31 - this.m21 * this.m30;
		float f7 = this.m20 * this.m32 - this.m22 * this.m30;
		float f8 = this.m20 * this.m33 - this.m23 * this.m30;
		float f9 = this.m21 * this.m32 - this.m22 * this.m31;
		float f10 = this.m21 * this.m33 - this.m23 * this.m31;
		float f11 = this.m22 * this.m33 - this.m23 * this.m32;
		float f12 = this.m11 * f11 - this.m12 * f10 + this.m13 * f9;
		float f13 = -this.m10 * f11 + this.m12 * f8 - this.m13 * f7;
		float f14 = this.m10 * f10 - this.m11 * f8 + this.m13 * f6;
		float f15 = -this.m10 * f9 + this.m11 * f7 - this.m12 * f6;
		float f16 = -this.m01 * f11 + this.m02 * f10 - this.m03 * f9;
		float f17 = this.m00 * f11 - this.m02 * f8 + this.m03 * f7;
		float f18 = -this.m00 * f10 + this.m01 * f8 - this.m03 * f6;
		float f19 = this.m00 * f9 - this.m01 * f7 + this.m02 * f6;
		float f20 = this.m31 * f5 - this.m32 * f4 + this.m33 * f3;
		float f21 = -this.m30 * f5 + this.m32 * f2 - this.m33 * f1;
		float f22 = this.m30 * f4 - this.m31 * f2 + this.m33 * f;
		float f23 = -this.m30 * f3 + this.m31 * f1 - this.m32 * f;
		float f24 = -this.m21 * f5 + this.m22 * f4 - this.m23 * f3;
		float f25 = this.m20 * f5 - this.m22 * f2 + this.m23 * f1;
		float f26 = -this.m20 * f4 + this.m21 * f2 - this.m23 * f;
		float f27 = this.m20 * f3 - this.m21 * f1 + this.m22 * f;
		this.m00 = f12;
		this.m10 = f13;
		this.m20 = f14;
		this.m30 = f15;
		this.m01 = f16;
		this.m11 = f17;
		this.m21 = f18;
		this.m31 = f19;
		this.m02 = f20;
		this.m12 = f21;
		this.m22 = f22;
		this.m32 = f23;
		this.m03 = f24;
		this.m13 = f25;
		this.m23 = f26;
		this.m33 = f27;
		return f * f11 - f1 * f10 + f2 * f9 + f3 * f8 - f4 * f7 + f5 * f6;
	}

	public void transpose() {
		float f = this.m10;
		this.m10 = this.m01;
		this.m01 = f;
		f = this.m20;
		this.m20 = this.m02;
		this.m02 = f;
		f = this.m21;
		this.m21 = this.m12;
		this.m12 = f;
		f = this.m30;
		this.m30 = this.m03;
		this.m03 = f;
		f = this.m31;
		this.m31 = this.m13;
		this.m13 = f;
		f = this.m32;
		this.m32 = this.m23;
		this.m23 = f;
	}

	public boolean invert() {
		float f = this.adjugateAndDet();
		if (Math.abs(f) > 1.0E-6F) {
			this.multiply(f);
			return true;
		} else {
			return false;
		}
	}

	public void multiply(Matrix4f matrix) {
		float f00 = this.m00 * matrix.m00 + this.m01 * matrix.m10 + this.m02 * matrix.m20 + this.m03 * matrix.m30;
		float f01 = this.m00 * matrix.m01 + this.m01 * matrix.m11 + this.m02 * matrix.m21 + this.m03 * matrix.m31;
		float f02 = this.m00 * matrix.m02 + this.m01 * matrix.m12 + this.m02 * matrix.m22 + this.m03 * matrix.m32;
		float f03 = this.m00 * matrix.m03 + this.m01 * matrix.m13 + this.m02 * matrix.m23 + this.m03 * matrix.m33;
		float f10 = this.m10 * matrix.m00 + this.m11 * matrix.m10 + this.m12 * matrix.m20 + this.m13 * matrix.m30;
		float f11 = this.m10 * matrix.m01 + this.m11 * matrix.m11 + this.m12 * matrix.m21 + this.m13 * matrix.m31;
		float f12 = this.m10 * matrix.m02 + this.m11 * matrix.m12 + this.m12 * matrix.m22 + this.m13 * matrix.m32;
		float f13 = this.m10 * matrix.m03 + this.m11 * matrix.m13 + this.m12 * matrix.m23 + this.m13 * matrix.m33;
		float f20 = this.m20 * matrix.m00 + this.m21 * matrix.m10 + this.m22 * matrix.m20 + this.m23 * matrix.m30;
		float f21 = this.m20 * matrix.m01 + this.m21 * matrix.m11 + this.m22 * matrix.m21 + this.m23 * matrix.m31;
		float f22 = this.m20 * matrix.m02 + this.m21 * matrix.m12 + this.m22 * matrix.m22 + this.m23 * matrix.m32;
		float f23 = this.m20 * matrix.m03 + this.m21 * matrix.m13 + this.m22 * matrix.m23 + this.m23 * matrix.m33;
		float f30 = this.m30 * matrix.m00 + this.m31 * matrix.m10 + this.m32 * matrix.m20 + this.m33 * matrix.m30;
		float f31 = this.m30 * matrix.m01 + this.m31 * matrix.m11 + this.m32 * matrix.m21 + this.m33 * matrix.m31;
		float f32 = this.m30 * matrix.m02 + this.m31 * matrix.m12 + this.m32 * matrix.m22 + this.m33 * matrix.m32;
		float f33 = this.m30 * matrix.m03 + this.m31 * matrix.m13 + this.m32 * matrix.m23 + this.m33 * matrix.m33;
		this.m00 = f00;
		this.m01 = f01;
		this.m02 = f02;
		this.m03 = f03;
		this.m10 = f10;
		this.m11 = f11;
		this.m12 = f12;
		this.m13 = f13;
		this.m20 = f20;
		this.m21 = f21;
		this.m22 = f22;
		this.m23 = f23;
		this.m30 = f30;
		this.m31 = f31;
		this.m32 = f32;
		this.m33 = f33;
	}

	public void multiply(float multiplier) {
		this.m00 *= multiplier;
		this.m01 *= multiplier;
		this.m02 *= multiplier;
		this.m03 *= multiplier;
		this.m10 *= multiplier;
		this.m11 *= multiplier;
		this.m12 *= multiplier;
		this.m13 *= multiplier;
		this.m20 *= multiplier;
		this.m21 *= multiplier;
		this.m22 *= multiplier;
		this.m23 *= multiplier;
		this.m30 *= multiplier;
		this.m31 *= multiplier;
		this.m32 *= multiplier;
		this.m33 *= multiplier;
	}

	public static Matrix4f perspective(double fov, float aspectRatio, float nearPlane, float farPlane) {
		float f = (float) (1.0D / Math.tan(Math.toRadians(fov) * 0.5D));
		Matrix4f matrix4f = new Matrix4f();
		matrix4f.m00 = f / aspectRatio;
		matrix4f.m11 = f;
		matrix4f.m22 = (farPlane + nearPlane) / (nearPlane - farPlane);
		matrix4f.m32 = -1.0F;
		matrix4f.m23 = 2.0F * farPlane * nearPlane / (nearPlane - farPlane);
		return matrix4f;
	}

	public static Matrix4f orthographic(float width, float height, float nearPlane, float farPlane) {
		Matrix4f matrix4f = new Matrix4f();
		matrix4f.m00 = 2.0F / width;
		matrix4f.m11 = 2.0F / height;
		float f = farPlane - nearPlane;
		matrix4f.m22 = -2.0F / f;
		matrix4f.m33 = 1.0F;
		matrix4f.m03 = -1.0F;
		matrix4f.m13 = -1.0F;
		matrix4f.m23 = -(farPlane + nearPlane) / f;
		return matrix4f;
	}

	public Matrix4f copy() {
		return new Matrix4f(this);
	}

	public static Matrix4f createIdentityMatrix() {
		Matrix4f matrix4f = new Matrix4f();
		matrix4f.m00 = 1.0F;
		matrix4f.m11 = 1.0F;
		matrix4f.m22 = 1.0F;
		matrix4f.m33 = 1.0F;
		return matrix4f;
	}

	public static Matrix4f createScaleMatrix(float x, float y, float z) {
		Matrix4f matrix4f = new Matrix4f();
		matrix4f.m00 = x;
		matrix4f.m11 = y;
		matrix4f.m22 = z;
		matrix4f.m33 = 1.0F;
		return matrix4f;
	}

	public static Matrix4f createTranslateMatrix(float x, float y, float z) {
		Matrix4f matrix4f = new Matrix4f();
		matrix4f.m00 = 1.0F;
		matrix4f.m11 = 1.0F;
		matrix4f.m22 = 1.0F;
		matrix4f.m33 = 1.0F;
		matrix4f.m03 = x;
		matrix4f.m13 = y;
		matrix4f.m23 = z;
		return matrix4f;
	}

	public void translate(float x, float y, float z) {
		this.m03 += this.m00 * x + this.m01 * y + this.m02 * z;
		this.m13 += this.m10 * x + this.m11 * y + this.m12 * z;
		this.m23 += this.m20 * x + this.m21 * y + this.m22 * z;
		this.m33 += this.m30 * x + this.m31 * y + this.m32 * z;
	}

	public void scale(float x, float y, float z) {
		this.m00 *= x;
		this.m10 *= x;
		this.m20 *= x;
		this.m30 *= x;
		this.m01 *= y;
		this.m11 *= y;
		this.m21 *= y;
		this.m31 *= y;
		this.m02 *= z;
		this.m12 *= z;
		this.m22 *= z;
		this.m32 *= z;
	}

	public void rotate(float radian, float x, float y, float z) {
		if (radian == 0.0F)
			return;
		if (x == 0.0F) {
			if (y == 0.0F) {
				if (z == 0.0F) {
					return;
				} else {
					this.rotateZ(radian, z);
					return;
				}
			} else if (z == 0.0F) {
				this.rotateY(radian, y);
				return;
			}
		} else if (y == 0.0F && z == 0.0F) {
			this.rotateX(radian, x);
			return;
		}

		// setup quaternion
		float q = MathHelper.sin(radian * 0.5F);
		float qx = x * q;
		float qy = y * q;
		float qz = z * q;
		float qw = MathHelper.cos(radian * 0.5F);

		// setup matrix
		float xx = 2.0F * qx * qx;
		float yy = 2.0F * qy * qy;
		float zz = 2.0F * qz * qz;
		float xy = qx * qy;
		float yz = qy * qz;
		float zx = qz * qx;
		float xw = qx * qw;
		float yw = qy * qw;
		float zw = qz * qw;

		float r00 = 1.0F - yy - zz;
		float r11 = 1.0F - zz - xx;
		float r22 = 1.0F - xx - yy;
		float r10 = 2.0F * (xy + zw);
		float r01 = 2.0F * (xy - zw);
		float r20 = 2.0F * (zx - yw);
		float r02 = 2.0F * (zx + yw);
		float r21 = 2.0F * (yz + xw);
		float r12 = 2.0F * (yz - xw);

		// rotate
		float f00 = this.m00 * r00 + this.m01 * r10 + this.m02 * r20;
		float f01 = this.m00 * r01 + this.m01 * r11 + this.m02 * r21;
		float f02 = this.m00 * r02 + this.m01 * r12 + this.m02 * r22;
		float f10 = this.m10 * r00 + this.m11 * r10 + this.m12 * r20;
		float f11 = this.m10 * r01 + this.m11 * r11 + this.m12 * r21;
		float f12 = this.m10 * r02 + this.m11 * r12 + this.m12 * r22;
		float f20 = this.m20 * r00 + this.m21 * r10 + this.m22 * r20;
		float f21 = this.m20 * r01 + this.m21 * r11 + this.m22 * r21;
		float f22 = this.m20 * r02 + this.m21 * r12 + this.m22 * r22;
		float f30 = this.m30 * r00 + this.m31 * r10 + this.m32 * r20;
		float f31 = this.m30 * r01 + this.m31 * r11 + this.m32 * r21;
		float f32 = this.m30 * r02 + this.m31 * r12 + this.m32 * r22;

		this.m00 = f00;
		this.m01 = f01;
		this.m02 = f02;
		this.m10 = f10;
		this.m11 = f11;
		this.m12 = f12;
		this.m20 = f20;
		this.m21 = f21;
		this.m22 = f22;
		this.m30 = f30;
		this.m31 = f31;
		this.m32 = f32;
	}

	public void rotateX(float radian, float x) {
		if (radian == 0.0F || x == 0.0F)
			return;

		// setup quaternion
		float qx = x * MathHelper.sin(radian * 0.5F);
		float qw = MathHelper.cos(radian * 0.5F);

		// setup matrix
		float xx = 2.0F * qx * qx;
		float xw = qx * qw;

		float r11 = 1.0F - xx;
		float r22 = 1.0F - xx;
		float r21 = 2.0F * xw;
		float r12 = 2.0F * -xw;

		// rotate
		float f01 = this.m01 * r11 + this.m02 * r21;
		float f02 = this.m01 * r12 + this.m02 * r22;
		float f11 = this.m11 * r11 + this.m12 * r21;
		float f12 = this.m11 * r12 + this.m12 * r22;
		float f21 = this.m21 * r11 + this.m22 * r21;
		float f22 = this.m21 * r12 + this.m22 * r22;
		float f31 = this.m31 * r11 + this.m32 * r21;
		float f32 = this.m31 * r12 + this.m32 * r22;

		this.m01 = f01;
		this.m02 = f02;
		this.m11 = f11;
		this.m12 = f12;
		this.m21 = f21;
		this.m22 = f22;
		this.m31 = f31;
		this.m32 = f32;
	}

	public void rotateY(float radian, float y) {
		if (radian == 0.0F || y == 0.0F)
			return;

		// setup quaternion
		float qy = y * MathHelper.sin(radian * 0.5F);
		float qw = MathHelper.cos(radian * 0.5F);

		// setup matrix
		float yy = 2.0F * qy * qy;
		float yw = qy * qw;

		float r00 = 1.0F - yy;
		float r22 = 1.0F - yy;
		float r20 = 2.0F * -yw;
		float r02 = 2.0F * yw;

		// rotate
		float a00 = this.m00 * r00 + this.m02 * r20;
		float a02 = this.m00 * r02 + this.m02 * r22;
		float a10 = this.m10 * r00 + this.m12 * r20;
		float a12 = this.m10 * r02 + this.m12 * r22;
		float a20 = this.m20 * r00 + this.m22 * r20;
		float a22 = this.m20 * r02 + this.m22 * r22;
		float a30 = this.m30 * r00 + this.m32 * r20;
		float a32 = this.m30 * r02 + this.m32 * r22;

		this.m00 = a00;
		this.m02 = a02;
		this.m10 = a10;
		this.m12 = a12;
		this.m20 = a20;
		this.m22 = a22;
		this.m30 = a30;
		this.m32 = a32;
	}

	public void rotateZ(float radian, float z) {
		if (radian == 0.0F || z == 0.0F)
			return;

		// setup quaternion
		float qz = z * MathHelper.sin(radian * 0.5F);
		float qw = MathHelper.cos(radian * 0.5F);

		// setup matrix
		float zz = 2.0F * qz * qz;
		float zw = qz * qw;

		float r00 = 1.0F - zz;
		float r11 = 1.0F - zz;
		float r10 = 2.0F * zw;
		float r01 = 2.0F * -zw;

		// rotate
		float a00 = this.m00 * r00 + this.m01 * r10;
		float a01 = this.m00 * r01 + this.m01 * r11;
		float a10 = this.m10 * r00 + this.m11 * r10;
		float a11 = this.m10 * r01 + this.m11 * r11;
		float a20 = this.m20 * r00 + this.m21 * r10;
		float a21 = this.m20 * r01 + this.m21 * r11;
		float a30 = this.m30 * r00 + this.m31 * r10;
		float a31 = this.m30 * r01 + this.m31 * r11;

		this.m00 = a00;
		this.m01 = a01;
		this.m10 = a10;
		this.m11 = a11;
		this.m20 = a20;
		this.m21 = a21;
		this.m30 = a30;
		this.m31 = a31;
	}

}
